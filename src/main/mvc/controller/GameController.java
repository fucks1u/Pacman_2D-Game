package src.main.mvc.controller;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Comparator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.awt.Component;

import src.main.mvc.model.character.GhostModel;
import src.main.mvc.model.character.PacmanModel;
import src.main.mvc.model.character.ghost.InkyModel;
import src.main.mvc.model.item.BigDotModel;
import src.main.mvc.model.item.FruitModel;
import src.main.mvc.model.item.ItemModel;
import src.main.mvc.model.item.WallModel;
import src.main.mvc.model.item.fruit.CherryModel;
import src.main.mvc.model.map.Level1;
import src.main.mvc.model.map.MapModel;
import src.main.mvc.utils.Clock;
import src.main.mvc.view.frames.MenuFrame;

public class GameController implements ActionListener, KeyListener {
	private int score = 0;
	private int highscore = 0;
	private int nbFruits = 1;
	private int monstersEated = 1;

	private MapModel map;
	private PacmanModel pacman;
	private List<GhostModel> ghosts;
	private List<FruitModel> fruits;
	private List<Clock> clocks;
	private MenuFrame mainframe;
	private boolean isStarted;
	private boolean first;

	private enum nextDirection {
		UP,
		DOWN,
		LEFT,
		RIGHT
	}

	private String namePlayer;
	private nextDirection next;

	// TODO : Javadoc
	// TODO : Set name of the player
	// TODO : Display mob + fruit eated

	public GameController(MapModel map, MenuFrame mainframe, PacmanModel pacman, List<GhostModel> ghostlist) {

		this.map = map;
		this.mainframe = mainframe;
		this.pacman = pacman;
		this.ghosts = ghostlist;
		this.isStarted = false;
		this.clocks = new ArrayList<>();
		first = true;
		for (Component c : mainframe.getButtonsPanel().getComponents())
			((JButton) c).addActionListener(this);
		this.fruits = Arrays.asList(
				new CherryModel(70),
				new CherryModel(140),
				new CherryModel(210));
	}

	/**
	 * This method runs the game loop until either the player runs out of lives or
	 * all the dots on the map are eaten.
	 * It updates the direction of the Pacman depending on the user inputs and moves
	 * the Pacman accordingly.
	 * It also checks for collisions with other game objects and updates the score
	 * accordingly.
	 */
	public void game() {
		Clock ghosttimer = new Clock();
		Clock pacmanTimer = new Clock();
		Clock fruitTimer = new Clock();
		Clock fpsTimer = new Clock();
		Clock moveTimer = new Clock();
		Clock gametimer = null;
		clocks.add(ghosttimer);
		clocks.add(pacmanTimer);
		clocks.add(fruitTimer);
		clocks.add(fpsTimer);
		clocks.add(moveTimer);
		int fps = 0;
		Clock vulnerabilityTimer = new Clock();
		HashMap<String, Point> basePositions = new HashMap<>();

		for (GhostModel ghost : ghosts) {
			Point position = ghost.getPosition();
			basePositions.put(ghost.getName(), new Point((int) position.getX(), (int) position.getY()));
		}

		while (pacman.getLives() > 0 && map.getDot() > 0) {
			if (fpsTimer.getSec() >= 1) {
				System.out.printf("[GCtrl] FPS: %d, Time: %d%n", fps, pacmanTimer.getSec());
				fpsTimer.reset();
				fps = 0;
			} else {
				fps++;
			}
			if (isStarted) {
				if (first) {
					gametimer = new Clock();
					this.mainframe.getPanelHud().getDetailsScore().setTimerlabel(gametimer);
					first = false;
				}
				this.mainframe.getPanelHud().getDetailsScore().setTimerlabel(gametimer);

				if (moveTimer.getMs() >= 90) {
					moveTimer.reset();

					checkNextPosition(next);
					if (checkCell()) {
						pacman.move();
						if (map.getCell(pacman.getPosition()) != null) {
							if(map.getCell(pacman.getPosition()) instanceof FruitModel){
								this.mainframe.getPanelHud().getDetailsScore().setFruitslabel(this.nbFruits++);
							}
							this.score += map.getCell(pacman.getPosition()).getScore();
							if (map.getCell(pacman.getPosition()) instanceof BigDotModel) {
								vulnerabilityTimer.reset();
								for (GhostModel ghost : ghosts)
									ghost.setVulnerable(true);
							}
							map.setCell(pacman.getPosition());
							mainframe.getPanelHud().updateScore(this.score);
						}
					}
				}

				if (ghosttimer.getMs() >= 140) {
					ghosttimer.reset();

					InkyModel inky = (InkyModel) this.ghosts.get(2);
					List<Point> ghostsPositions = new ArrayList<>();
					for (GhostModel ghost : this.ghosts) {
						ghostsPositions.add(ghost.getPosition());
					}

					this.ghosts.get(0).move(this.pacman.getPosition(), map);
					this.ghosts.get(1).move(this.pacman.getPosition(), map);
					inky.move(this.pacman.getPosition(), map, ghostsPositions);
					this.ghosts.get(3).move(this.pacman.getPosition(), map);
				}

				if (vulnerabilityTimer.getSec() >= 10) {
					for (GhostModel ghost : ghosts) {
						if (ghost.isVulnerable()) {
							ghost.setVulnerable(false);
						}
					}
				}

				if (FruitModel.isPlaced() && fruitTimer.getSec() >= 10) {
					for (FruitModel fruit : this.fruits) {
						if (fruit.isActive()) {
							map.setCell(fruit.getPosition());
							FruitModel.setPlaced(false);
							fruit.setActive(false);
							fruitTimer.reset();
						}
					}
				}

				spawnItem(fruits, fruitTimer);
				checkCollision(basePositions);
				mainframe.getPanelGame().repaint();
			}
			try {
				TimeUnit.MILLISECONDS.sleep((long) 16.666666667);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		/**
		 * End condition :
		 * If the player has no more lives or if there is no more dots on the map.
		 */
		if (pacman.getLives() <= 0 || map.getDot() <= 0) {
			this.isStarted = false;
			boolean response;
			mainframe.getContentPane().removeAll();
			if (pacman.getLives() <= 0) {
				response = mainframe.displayGameOver("lose");
				System.out.println("[GCtrl] Game won.");
			} else {
				response = mainframe.displayGameOver("win");
				System.out.println("[GCtrl] Game lost.");
			}
			removeListeners(mainframe.getPanelGame().getComponents());
			Object selectedValue = mainframe.getOptionPane().getValue();
			if (selectedValue == null) {
				mainframe.getContentPane().removeAll();
				mainframe.displayMenu();
				addListeners(mainframe.getButtonsPanel().getComponents());
			} else if (selectedValue.equals("Yes")) {
				if (!response) {
					String name = JOptionPane.showInputDialog(mainframe, "What's your name?", "New Player",
							JOptionPane.QUESTION_MESSAGE);
					while (name == null) {
						name = JOptionPane.showInputDialog(mainframe, "What's your name?", "New Player",
								JOptionPane.QUESTION_MESSAGE);
					}
					this.updateScore(name, this.score);
				}
				mainframe.getContentPane().removeAll();
				mainframe.displayGame();
				mainframe.getPanelHud().updateHighscore(this.highscore);
			} else if (selectedValue.equals("No")) {
				mainframe.getContentPane().removeAll();
				mainframe.displayMenu();
				addListeners(mainframe.getButtonsPanel().getComponents());
			}
			this.reset();
			this.mainframe.getPanelHud().getDetailsScore().setTimerlabel(null);
			this.first = true;
			this.next = null;
			this.game();
		}
	}

	/**
	 * Checks if the cell in front of Pacman is a valid move.
	 *
	 * @return true if the cell is not a wall, false otherwise.
	 */
	public boolean checkCell() {
		if (pacman.getDirection() == null) {
			return false;
		} else {
			Point cell = pacman.getPosition().getLocation();
			switch (pacman.getDirection()) {
				case UP:
					cell.setLocation(cell.getX(), cell.getY() - 1);
					break;
				case DOWN:
					cell.setLocation(cell.getX(), cell.getY() + 1);
					break;
				case LEFT:
					cell.setLocation(cell.getX() - 1, cell.getY());
					break;
				case RIGHT:
					cell.setLocation(cell.getX() + 1, cell.getY());
					break;
			}

			for (Point spawn : map.getGhostSpawn()) {
				if (cell.getX() == spawn.getX() && cell.getY() == spawn.getY()) {
					return false;
				}
			}

			if (map.getCell(cell) instanceof WallModel
					|| cell.getY() <= 0
					|| cell.getY() >= map.getMap()[0].length
					|| cell.getX() <= 0
					|| cell.getX() >= map.getMap().length) {
				return false;
			}
			return true;
		}
	}

	/**
	 * Checks for collision between Pacman and ghosts, and decrements Pacman's lives
	 * if there is a collision.
	 */
	public void checkCollision(HashMap<String, Point> basePositions) {
		Point pacPos = this.pacman.getPosition().getLocation();

		for (GhostModel ghost : this.ghosts) {
			Point ghostPos = ghost.getPosition().getLocation();
			if (pacPos.getX() == ghostPos.getX() && pacPos.getY() == ghostPos.getY()) {
				if (ghost.isVulnerable() && basePositions.containsKey(ghost.getName())) {
					ghost.setPosition(basePositions.get(ghost.getName()));
					ghost.setVulnerable(false);
					System.out.printf("[GCtrl] %s eated by pacman, coming back to spawn (%B).%n", ghost.getName(),
							ghost.isVulnerable());
					this.score += 500;
					this.mainframe.getPanelHud().getDetailsScore().setMonsterslabel(this.monstersEated++);
				} else {
					this.pacman.setLives(this.pacman.getLives() - 1);
					this.mainframe.getPanelHud().updateLife(this.pacman.getLives());
					System.out.printf("[GCtrl] %s touched %s, he now have %d lives.%n", pacman.getClass().getSimpleName(),
							ghost.getClass().getSimpleName(), pacman.getLives());
				}
			}
		}
	}

	/**
	 * Spawns a fruit item on the game map if certain conditions are met.
	 *
	 * @param fruits a list of FruitModel objects to choose from for spawning
	 */
	public void spawnItem(List<FruitModel> fruits, Clock timer) {
		int dots = this.map.getDot();

		if (dots % 70 == 0 && dots / 70 <= fruits.size() && !FruitModel.isPlaced() && dots >= 10) {
			FruitModel fruit = fruits.get(dots / 70 - 1);
			ItemModel[][] map = this.map.getMap();
			List<Point> freeCells = new ArrayList<>();
			List<Point> spawn = this.map.getSpawn();

			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map[i].length; j++) {
					if (map[i][j] == null && !spawn.contains(new Point(i, j))
							&& !this.map.getVoids().contains(new Point(i, j)) && (i != 14 && (j != 0 || j != 27))) {
						freeCells.add(new Point(i, j));
					}
				}
			}
			int randInt = new Random().nextInt(freeCells.size() - 1);
			this.map.setCell(freeCells.get(randInt), fruit);
			fruit.setPosition(freeCells.get(randInt));
			fruit.setActive(true);
			timer.reset();
			this.mainframe.getPanelGame().repaint();
			FruitModel.setPlaced(true);
		}
	}

	public void addListeners(Component[] cmp) {
		for (Component c : cmp) {
			((JButton) c).addActionListener(this);
		}
	}

	public void removeListeners(Component[] cmp) {
		for (Component c : cmp) {
			((JButton) c).removeActionListener(this);
		}
	}

	public void checkNextPosition(nextDirection nextdirection) {
		if (map.isTeleporter(pacman.getPosition())) {
			this.pacman.setPosition(map.getTeleporter(pacman.getPosition()));
			return;
		}
		if (nextdirection == null) {
			return;
		}
		int posX = pacman.getPosition().x;
		int posY = pacman.getPosition().y;
		switch (nextdirection) {
			case UP:
				if (map.isAccessible(new Point(posX, posY - 1))) {
					this.pacman.setDirection(PacmanModel.directions.UP);
				}
				break;
			case DOWN:
				if (map.isAccessible(new Point(posX, posY + 1))) {
					this.pacman.setDirection(PacmanModel.directions.DOWN);
				}
				break;
			case LEFT:
				if (map.isAccessible(new Point(posX - 1, posY))) {
					this.pacman.setDirection(PacmanModel.directions.LEFT);
				}
				break;
			case RIGHT:
				if (map.isAccessible(new Point(posX + 1, posY))) {
					this.pacman.setDirection(PacmanModel.directions.RIGHT);
				}
				break;
		}
	}

	/**
	 * This method is to reset all the variables of the game.
	 * It is used when the player wants to play again.
	 */
	public void reset() {
		this.score = 0;
		this.nbFruits = 0;
		this.monstersEated = 0;
		int i = 0;
		this.isStarted = false;

		if (this.highscore != 0) {
			this.mainframe.getPanelHud().updateHighscore(this.highscore);
		}

		this.mainframe.getPanelHud().updateScore(this.score);
		this.pacman.setLives(1);
		this.mainframe.getPanelHud().updateLife(this.pacman.getLives());
		this.pacman.setPosition(new Point(18, 13));
		for(GhostModel ghost : this.ghosts){
			ghost.setPosition(new Point(13, 12+i));
			i++;
		}
		for (Clock c : this.clocks) {
			c.reset();
		}
		this.map = new Level1();
		this.mainframe.getPanelGame().setMap(this.map.getMap());
	}

	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		String key = actionEvent.getActionCommand();

		switch (key) {
			case "Play":
				mainframe.getContentPane().removeAll();
				mainframe.displayGame();
				mainframe.addKeyListener(this);
				addListeners(mainframe.getPanelGame().getComponents());
				break;
			case "Score":
				mainframe.getContentPane().removeAll();
				mainframe.displayScore();
				addListeners(mainframe.getNewPlayerPanel().getComponents());
				break;
			case "Quit":
				System.exit(0);
				break;
			case "New Player":
				String name = JOptionPane.showInputDialog(mainframe, "What's your name?", "New Player",
						JOptionPane.QUESTION_MESSAGE);
				if (name == null) {
					mainframe.getContentPane().removeAll();
					mainframe.displayScore();
					addListeners(mainframe.getNewPlayerPanel().getComponents());
					break;
				}
				while (name.isEmpty() || name.length() > 25 || name.charAt(0) == ' ' || name.matches(".*[.,;:?!/].*")) {
					JOptionPane.showMessageDialog(mainframe, String.format(
							"Your name must :%n - have between 1 and 25 caracters %n - not begin with a space %n - not contains special characters(.,;:?!/)."),
							"Error", JOptionPane.ERROR_MESSAGE);
					name = JOptionPane.showInputDialog(mainframe, "What's your name?", "New Player",
							JOptionPane.QUESTION_MESSAGE);
					if (name == null) {
						mainframe.getContentPane().removeAll();
						mainframe.displayScore();
						break;
					}
				}
				mainframe.addPlayer(name);
				mainframe.getContentPane().removeAll();
				mainframe.displayScore();
				break;
			case "Back":
				removeListeners(mainframe.getButtonsPanel().getComponents());
				mainframe.getContentPane().removeAll();
				mainframe.displayMenu();
				addListeners(mainframe.getButtonsPanel().getComponents());
				break;
			default:
				break;
		}
	}

	@Override
	public void keyTyped(KeyEvent keyEvent) {
	}

	@Override
	public void keyPressed(KeyEvent keyEvent) {
	}

	/**
	 * This method processes the user inputs and updates the direction of the
	 * Pacman.
	 * Z,Q,S,D and the arrow keys are used to move the Pacman.
	 * Left, Right, Up, Down are used to move the Pacman.
	 * 
	 * @param keyEvent the event to be processed
	 */
	@Override
	public void keyReleased(KeyEvent keyEvent) {
		switch (keyEvent.getKeyCode()) {
			case KeyEvent.VK_UP, KeyEvent.VK_Z:
				if (map.isAccessible(new Point(pacman.getPosition().x, pacman.getPosition().y - 1))) {
					this.pacman.setDirection(PacmanModel.directions.UP);
				}
				if (checkCell()) {
					this.next = nextDirection.UP;
				}
				break;
			case KeyEvent.VK_DOWN, KeyEvent.VK_S:
				if (map.isAccessible(new Point(pacman.getPosition().x, pacman.getPosition().y + 1))) {
					if (this.pacman.getPosition().equals(new Point(14, 26))) {
						return;
					}
					this.pacman.setDirection(PacmanModel.directions.DOWN);
					this.next = null;
				}
				if (checkCell()) {
					this.next = nextDirection.DOWN;
				}
				break;
			case KeyEvent.VK_LEFT, KeyEvent.VK_Q:
				if (map.isAccessible(new Point(pacman.getPosition().x - 1, pacman.getPosition().y))) {
					this.pacman.setDirection(PacmanModel.directions.LEFT);
					this.next = null;
				}
				if (checkCell()) {
					this.next = nextDirection.LEFT;
				}
				break;
			case KeyEvent.VK_RIGHT, KeyEvent.VK_D:
				if (map.isAccessible(new Point(pacman.getPosition().x + 1, pacman.getPosition().y))) {
					if (this.pacman.getPosition().equals(new Point(14, 1))) {
						return;
					}
					this.pacman.setDirection(PacmanModel.directions.RIGHT);
					this.next = null;
				}
				if (checkCell()) {
					this.next = nextDirection.RIGHT;
				}
				break;
			default:
				break;
		}
		this.isStarted = true;
	}

	/**
	 * This method updates the score of a player in the file leaderboard.txt.
	 * It updates the score of the player if it is higher than the previous one.
	 * 
	 * @param name  The name of the player.
	 * @param score The score of the player.
	 */
	public void updateScore(String name, int score) {
		try {
			List<String> lines = readFile("src/main/resources/leaderboard.txt");

			if (containtName(lines, name)) {
				updateScore(lines, name, score);
			} else {
				addNewPlayer(lines, name, score);
			}

			sortAndWriteInFile("src/main/resources/leaderboard.txt", lines);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method reads the file leaderboard.txt and returns the lines of the file.
	 * It returns a List of String with the lines of the file.
	 * 
	 * @param file The file to read.
	 * @return A List of String with the lines of the file.
	 * @throws IOException If the file doesn't exist.
	 */
	private List<String> readFile(String file) throws IOException {
		List<String> lines = new ArrayList<>();

		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String ligne;
			while ((ligne = br.readLine()) != null) {
				lines.add(ligne);
			}
		}

		return lines;
	}

	/**
	 * This method adds a new player in the file leaderboard.txt.
	 * It adds the name and the score of the player in the file.
	 * 
	 * @param lines The lines of the file leaderboard.txt.
	 * @param name  The name of the player.
	 * @param score The score of the player.
	 */
	private void addNewPlayer(List<String> lines, String name, int score) {
		lines.add(formatLine(name, score));
	}

	/**
	 * This method checks if the file leaderboard.txt contains the name of the
	 * player.
	 * It returns true if the file contains the name of the player, false otherwise.
	 * 
	 * @param lines The lines of the file leaderboard.txt.
	 * @param name  The name of the player.
	 * @return true if the file contains the name of the player, false otherwise.
	 */
	private boolean containtName(List<String> lines, String name) {
		for (String line : lines) {
			if (line.startsWith(name + ":")) {
				return true;
			}
		}
		return false;
	}

	/**
	 * This method updates the score of a player in the file leaderboard.txt.
	 * It updates the score of the player if it is higher than the previous one.
	 * 
	 * @param lines    The lines of the file leaderboard.txt.
	 * @param name     The name of the player.
	 * @param newScore The new score of the player.
	 */
	private void updateScore(List<String> lines, String name, int newScore) {
		for (int i = 0; i < lines.size(); i++) {
			String ligne = lines.get(i);
			if (ligne.startsWith(name + ":")) {
				String[] elements = ligne.split(":");
				int scoreActuel = Integer.parseInt(elements[1]);
				if (newScore > scoreActuel) {
					lines.set(i, formatLine(name, newScore));
					this.highscore = newScore;
				}
				break;
			}
		}
	}

	/**
	 * This method sorts the lines of the file leaderboard.txt and writes them in
	 * the file.
	 * It sorts the lines by score.
	 * 
	 * @param file  The file to write in.
	 * @param lines The lines to write in the file.
	 * @throws IOException If the file doesn't exist.
	 */
	private void sortAndWriteInFile(String file, List<String> lines) throws IOException {
		lines.sort(Comparator.comparingInt((String s) -> Integer.parseInt(s.split(":")[1])).reversed());

		try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
			for (String line : lines) {
				bw.write(line);
				bw.newLine();
			}
		}
	}

	/**
	 * This method formats a line to write in the file leaderboard.txt.
	 * It returns a String with the name and the score of the player.
	 * 
	 * @param name  Name of the player.
	 * @param score Score of the player.
	 * @return A String with the name and the score of the player.
	 */
	private String formatLine(String name, int score) {
		return name + ":" + score;
	}

	private String getScore(String name) {
		try {
			List<String> lines = readFile("src/main/resources/leaderboard.txt");
			for (String line : lines) {
				if (line.startsWith(name + ":")) {
					String[] elements = line.split(":");
					return elements[1];
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
