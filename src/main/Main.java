package src.main;

import src.main.mvc.controller.GameController;
import src.main.mvc.model.character.GhostModel;
import src.main.mvc.model.character.PacmanModel;
import src.main.mvc.model.character.ghost.BlinkyModel;
import src.main.mvc.model.character.ghost.ClydeModel;
import src.main.mvc.model.character.ghost.InkyModel;
import src.main.mvc.model.character.ghost.PinkyModel;
import src.main.mvc.model.item.ItemModel;
import src.main.mvc.model.map.Level1;
import src.main.mvc.view.frames.MenuFrame;

import java.awt.Point;
import java.util.Arrays;
import java.util.List;

/**
 * Main class of the project.
 * It contains the main method.
 * It creates :
 * - the map
 * - the pacman
 * - a list of ghosts
 * - a JFrame to display the game
 * - a GameController to control the game
 * It calls the method game() from the GameController to launch the game loop.
 */
public class Main {
    public static void main(String[] args) {
        Level1 level1 = new Level1();
        PacmanModel pacman = new PacmanModel(new Point(18, 13));
        List<GhostModel> ghost = Arrays.asList(
                new BlinkyModel(new Point(13, 12)),
                new ClydeModel(new Point(13, 13)),
                new InkyModel(new Point(13, 14)),
                new PinkyModel(new Point(13, 15)));

        MenuFrame menu = new MenuFrame(level1.getMap(), pacman, ghost);
        GameController game = new GameController(level1, menu, pacman, ghost);
        game.game();
    }

    /**
     * Method to print the map in the console.
     * @param map the map to print.
     */
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
