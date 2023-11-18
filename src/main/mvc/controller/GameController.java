package src.main.mvc.controller;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.*;
import java.util.concurrent.TimeUnit;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.awt.Component;

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
import src.main.mvc.utils.Clock;
import src.main.mvc.view.frames.MenuFrame;

import static src.main.Main.printMap;

public class GameController implements ActionListener, KeyListener {
    private int score = 0;
    private MapModel map;
    private PacmanModel pacman;
    private List<GhostModel> ghosts;
    private List<FruitModel> fruits;
    private MenuFrame mainframe;
    private boolean isStarted;

    private enum nextDirection {
        UP,
        DOWN,
        LEFT,
        RIGHT
    }

    ;

    private nextDirection next;

    public GameController(MapModel map, MenuFrame mainframe, PacmanModel pacman, List<GhostModel> ghostlist) {

        this.map = map;
        this.mainframe = mainframe;
        this.pacman = pacman;
        this.ghosts = ghostlist;
        this.isStarted = false;
        for (Component c : mainframe.getButtonsPanel().getComponents()) ((JButton) c).addActionListener(this);
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
        Clock gameTimer = new Clock();
        Clock fpsTimer = new Clock();
        Clock moveTimer = new Clock();
        int fps = 0;
        while (pacman.getLives() > 0 && map.getDot() > 0) {
            if (fpsTimer.getSec() >= 1) {
                System.out.printf("[GCtrl] FPS: %d, Time: %d%n", fps, gameTimer.getSec());
                fpsTimer.reset();
                fps = 0;
            } else {
                fps++;
            }

            if (isStarted) {
                if (moveTimer.getMs() >= 90) {
                    moveTimer.reset();

                    checkNextPosition(next);
                    if (checkCell()) {
                        pacman.move();
                        System.out.printf("[GCtrl] Pacman: [x=%d, y=%d]%n", (int) this.pacman.getPosition().getX(),
                                (int) this.pacman.getPosition().getY());
                        if (map.getCell(pacman.getPosition()) != null) {
                            this.score += map.getCell(pacman.getPosition()).getScore();
                            map.setCell(pacman.getPosition());
                            mainframe.getPanelHud().updateScore(this.score);

                        }
                    }
                }
                if(ghosttimer.getMs() >= 140){
                    ghosttimer.reset();

                    this.ghosts.get(0).move(this.pacman.getPosition(), map);
                    System.out.printf("[GCtrl] Blinky: [x=%d, y=%d]%n", (int) this.ghosts.get(0).getPosition().getX(),
                            (int) this.ghosts.get(0).getPosition().getY());
                }

                if (FruitModel.isPlaced()) {
                    FruitModel currentFruit = null;
                    for (FruitModel fruit : this.fruits) {
                        if (!fruit.isExpired()) {
                            currentFruit = fruit;
                        }
                    }

//                    if (!currentFruit.isExpired()) {
//                        map.setCell(currentFruit.getPosition());
//                        FruitModel.setPlaced(false);
//                    }
                }

                spawnItem(fruits);
                checkCollision();
                mainframe.getPanelGame().repaint();
            }
            try {
                TimeUnit.MILLISECONDS.sleep((long) 16.666666667);
            } catch (Exception e) {
                e.printStackTrace();
            }
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

            if (map.getCell(cell) instanceof WallModel
                    || cell.getY() < 0
                    || cell.getY() > map.getMap()[0].length
                    || cell.getX() <= 0
                    || cell.getX() > map.getMap().length) {
                return false;
            }
            return true;
        }
    }

    /**
     * Checks for collision between Pacman and ghosts, and decrements Pacman's lives
     * if there is a collision.
     */
    public void checkCollision() {
        // TODO: handle collision when ghosts are vulnerables.
        Point pacPos = this.pacman.getPosition().getLocation();

        for (GhostModel ghost : this.ghosts) {
            Point ghostPos = ghost.getPosition().getLocation();
            if (pacPos.getX() == ghostPos.getX() && pacPos.getY() == ghostPos.getY()) {
                this.pacman.setLives(this.pacman.getLives() - 1);
                System.out.printf("[GCtrl] %s touched %s, he now have %d lives.%n", pacman.getClass().getSimpleName(),
                        ghost.getClass().getSimpleName(), pacman.getLives());
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
            FruitModel fruit = fruits.get(dots / 70 - 1);
            ItemModel[][] map = this.map.getMap();
            List<Point> freeCells = new ArrayList<>();
            List<Point> spawn = this.map.getSpawn();

            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map[i].length; j++) {
                    if (map[i][j] == null && !spawn.contains(new Point(i, j)) && !this.map.getVoids().contains(new Point(i, j))) {
                        freeCells.add(new Point(i, j));
                    }
                }
            }
            int randInt = new Random().nextInt(freeCells.size()-1);
            System.out.println("ici"+freeCells.size()+" : "+randInt);
            this.map.setCell(freeCells.get(randInt), fruit);
            fruit.setPosition(freeCells.get(randInt));
            fruit.setExpire();
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
        if(map.isTeleporter(pacman.getPosition())){
            System.out.println("aaa");
            this.pacman.setPosition(map.getTeleporter(pacman.getPosition()));
            return;
        }
        if(nextdirection == null){
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

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        String key = actionEvent.getActionCommand();

        switch (key) {
            case "Play":
                mainframe.getContentPane().removeAll();
                mainframe.displayGame();
                this.isStarted = true;
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

    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {

    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
        switch (keyEvent.getKeyCode()) {
            case KeyEvent.VK_UP:
                if (map.isAccessible(new Point(pacman.getPosition().x, pacman.getPosition().y - 1))) {
                    this.pacman.setDirection(PacmanModel.directions.UP);
                }
                if(checkCell()){
                    this.next = nextDirection.UP;
                }
                break;
            case KeyEvent.VK_DOWN:
                if (map.isAccessible(new Point(pacman.getPosition().x, pacman.getPosition().y + 1))) {
                    this.pacman.setDirection(PacmanModel.directions.DOWN);
                    this.next = null;
                }
                if(checkCell()){
                    this.next = nextDirection.DOWN;
                }
                break;
            case KeyEvent.VK_LEFT:
                if (map.isAccessible(new Point(pacman.getPosition().x - 1, pacman.getPosition().y))) {
                    this.pacman.setDirection(PacmanModel.directions.LEFT);
                    this.next = null;
                }
                if(checkCell()){
                    this.next = nextDirection.LEFT;
                }
                break;
            case KeyEvent.VK_RIGHT:
                if (map.isAccessible(new Point(pacman.getPosition().x + 1, pacman.getPosition().y))) {
                    this.pacman.setDirection(PacmanModel.directions.RIGHT);
                    this.next = null;
                }
                if(checkCell()){
                    this.next = nextDirection.RIGHT;
                }
                break;
            default:
                break;
        }
    }
}
