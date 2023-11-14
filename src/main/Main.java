package src.main;

import src.main.mvc.controller.GameController;
import src.main.mvc.model.item.ItemModel;
import src.main.mvc.model.map.Level1;
import src.main.mvc.view.frames.MenuFrame;

public class Main {
    public static void main(String[] args) {
        Level1 level1 = new Level1();
        ItemModel[][] map = level1.getMap();
        new MenuFrame();
        System.out.println("loading map...");
        printMap(map);
        GameController game = new GameController(level1);
        game.game();
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
