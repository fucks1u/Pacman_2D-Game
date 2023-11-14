package src.main;

import src.main.mvc.controller.GameController;
import src.main.mvc.model.character.PacmanModel;
import src.main.mvc.model.item.FruitModel;
import src.main.mvc.model.item.ItemModel;
import src.main.mvc.model.map.Level1;
import src.main.mvc.view.frames.MenuFrame;

import java.time.Duration;
import java.time.LocalTime;
import java.util.Objects;

public class Main {
    static GameController game;

    public static void main(String[] args) {
        Level1 level1 = new Level1();
//        ItemModel[][] map = level1.getMap();
//        System.out.println("loading map...");
//        printMap(map);
        MenuFrame mainframe = new MenuFrame(level1.getMap());
        game = new GameController(level1, mainframe);
        game(game);
    }

    /**
     * This method runs the game loop until either the player runs out of lives or
     * all the dots on the map are eaten.
     * It updates the direction of the Pacman depending on the user inputs and moves
     * the Pacman accordingly.
     * It also checks for collisions with other game objects and updates the score
     * accordingly.
     */
    public static void game(GameController g) {
        LocalTime startTime = null;
        while (g.getPacman().getLives() > 0 && g.getMap().getDot() > 0 && !g.isEnded()) {
            if (!g.isStarted()) {
                startTime = LocalTime.now();
            } else {
                Duration duration = Duration.between(Objects.requireNonNull(startTime), LocalTime.now());
                if (duration.toNanos() % 100000 == 0) {
                    int minutes = duration.toMinutesPart();
                    int seconds = duration.toSecondsPart();
                    // TODO: change direction depending on user input
                    g.getMainframe().getPanelHud().setTimer(minutes, seconds);
                    g.getPacman().setDirection(PacmanModel.directions.UP);

                    if (g.checkCell()) {
                        g.getPacman().move();

                        if (g.getMap().getCell(g.getPacman().getPosition()) != null) {
                            g.setScore(g.getMap().getCell(g.getPacman().getPosition()).getScore());
                            g.getMap().setCell(g.getPacman().getPosition());
                        }
                    }
                }

                if (FruitModel.isPlaced()) {
                    FruitModel currentFruit = null;
                    for (FruitModel fruit : g.getFruits()) {
                        if (fruit.getExpire() != null) {
                            currentFruit = fruit;
                        }
                    }

                    if (LocalTime.now().isAfter(currentFruit.getExpire())) {
                        g.getMap().setCell(currentFruit.getPosition());
                        FruitModel.setPlaced(false);
                    }
                    ;
                }

                g.spawnItem(g.getFruits());
                g.checkCollision();
            }
        }
    }


    public static void printMap(ItemModel[][] map) {
        for (int i = 0; i < 31; i++) {
            System.out.printf("%n");
            for (int j = 0; j < 28; j++) {
                if (map[i][j] == null) {
                    System.out.print("[N]");
                } else {
                    System.out.printf("[%s]", map[i][j].getClass().getName().split("\\.")[5].charAt(0));
                }
            }
        }
    }
}
