package src.main.mvc.controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import src.main.mvc.model.character.GhostModel;
import src.main.mvc.model.character.PacmanModel;
import src.main.mvc.model.character.ghost.BlinkyModel;
import src.main.mvc.model.character.ghost.ClydeModel;
import src.main.mvc.model.character.ghost.InkyModel;
import src.main.mvc.model.character.ghost.PinkyModel;
import src.main.mvc.model.item.FruitModel;
import src.main.mvc.model.item.ItemModel;
import src.main.mvc.model.item.WallModel;
import src.main.mvc.model.item.fruit.BellModel;
import src.main.mvc.model.item.fruit.CherryModel;
import src.main.mvc.model.item.fruit.OrangeModel;
import src.main.mvc.model.map.MapModel;
import src.main.mvc.view.frames.MenuFrame;

public class GameController implements ActionListener {
    private int score = 0;
    private MapModel map;
    private PacmanModel pacman;
    private List<GhostModel> ghosts;
    private List<FruitModel> fruits;
    private MenuFrame mainframe;
    private boolean isStarted = false;
    private boolean isPaused = false;
    private boolean isEnded = false;

    public GameController(MapModel map, MenuFrame mainframe) {
        this.map = map;

        this.mainframe = mainframe;
        for (Component c : mainframe.getButtonsPanel().getComponents()) ((JButton) c).addActionListener(this);

        this.pacman = new PacmanModel(new Point(16, 13));
        this.ghosts = Arrays.asList(
                new BlinkyModel(new Point(13, 12)),
                new ClydeModel(new Point(13, 13)),
                new InkyModel(new Point(13, 14)),
                new PinkyModel(new Point(13, 15)));
        this.fruits = Arrays.asList(
                new CherryModel(70),
                new BellModel(140),
                new OrangeModel(210));
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

            return !(map.getCell(cell) instanceof WallModel)
                    && !(cell.getY() <= 0)
                    && !(cell.getY() >= map.getMap()[0].length)
                    && !(cell.getX() <= 0)
                    && !(cell.getX() >= map.getMap().length);
        }
    }

    /**
     * Checks for collision between Pacman and ghosts, and decrements Pacman's lives
     * if there is a collision.
     */
    public void checkCollision() {
        for (GhostModel ghost : this.ghosts) {
            if (this.pacman.getPosition() == ghost.getPosition()) {
                this.pacman.setLives(this.pacman.getLives() - 1);
            }
        }
    }

    /**
     * Spawns a fruit item on the game map if certain conditions are met.
     *
     * @param fruits a list of FruitModel objects to choose from for spawning
     */
    public void spawnItem(List<FruitModel> fruits) {
        int dots = this.map.getDot();

        if (dots % 70 == 0 && dots / 70 <= fruits.size() && !FruitModel.isPlaced()) {
            FruitModel fruit = fruits.get(dots / 70);
            ItemModel[][] map = this.map.getMap();
            List<Point> freeCells = new ArrayList<>();

            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map[i].length; j++) {
                    if (map[i][j] == null) {
                        List<Point> spawn = this.map.getSpawn();
                        for (Point cell : spawn) {
                            if (!new Point(i, j).equals(cell)) {
                                freeCells.add(new Point(i, j));
                            }
                        }
                    }
                }
            }

            int randInt = (int) (Math.random() + freeCells.size());
            this.map.setCell(freeCells.get(randInt), fruit);
            fruit.setPosition(freeCells.get(randInt));
            fruit.setExpire(LocalTime.now().plusSeconds(10));
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

    /**
     * This method is called when an action is performed on the main frame.
     *
     * @param actionEvent The action performed.
     */
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        String key = actionEvent.getActionCommand();

        switch (key) {
            case "Play":
                mainframe.getContentPane().removeAll();
                mainframe.displayGame();
                isStarted = true;
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
                String name = JOptionPane.showInputDialog(mainframe, "What's your name?", "New Player", JOptionPane.QUESTION_MESSAGE);
                if (name == null) {
                    mainframe.getContentPane().removeAll();
                    mainframe.displayScore();
                    addListeners(mainframe.getNewPlayerPanel().getComponents());
                    break;
                }
                while (name.isEmpty() || name.length() > 25 || name.charAt(0) == ' ' || name.matches(".*[.,;:?!/].*")) {
                    JOptionPane.showMessageDialog(mainframe, String.format("Your name must :%n - have between 1 and 25 caracters %n - not begin with a space %n - not contains special characters(.,;:?!/)."), "Error", JOptionPane.ERROR_MESSAGE);
                    name = JOptionPane.showInputDialog(mainframe, "What's your name?", "New Player", JOptionPane.QUESTION_MESSAGE);
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

    public void setScore(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    public MapModel getMap() {
        return map;
    }

    public PacmanModel getPacman() {
        return pacman;
    }

    public List<GhostModel> getGhosts() {
        return ghosts;
    }

    public List<FruitModel> getFruits() {
        return fruits;
    }

    public MenuFrame getMainframe() {
        return mainframe;
    }

    public boolean isPaused() {
        return isPaused;
    }

    public boolean isEnded() {
        return isEnded;
    }

    public boolean isStarted() {
        return isStarted;
    }
}
