package src.main.mvc.view.panels.Game;

import src.main.mvc.model.item.ItemModel;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

/**
 * This class is a JPanel to show the game.
 * It contains the Game interface.
 */
public class GamePanel extends JPanel {
    private ItemModel[][] map;

    /**
     * Constructor of the GamePanel class.
     */
    public GamePanel(ItemModel[][] map) {
        this.map = map;
        this.setPreferredSize(new Dimension(532, 590));
        this.setBackground(Color.BLACK);
        this.setVisible(true);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;
        BufferedImage spriteWall = null;
        try {
            spriteWall = ImageIO.read(new File("src/main/resources/img/wall.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        int spriteWidth = 19;
        int spriteHeight = 19;
        for (int i = 0; i < 31; i++) {
            System.out.printf("%n");
            for (int j = 0; j < 28; j++) {
                int x = j * spriteWidth;
                int y = i * spriteHeight;
                if (map[i][j] == null) {
                    System.out.print("[N]");
                } else if (map[i][j].getClass().getName().split("\\.")[5].charAt(0) == 'W') {
                    g2d.drawImage(spriteWall, x, y, spriteWidth, spriteHeight, this);
                } else {
                    System.out.printf("[%s]", map[i][j].getClass().getName().split("\\.")[5].charAt(0));
                }
            }
        }
//        for (int i = 0; i < map.length; i++) {
//            for (int j = 0; j < map[i].length; j++) {
//                ItemModel sprite = map[i][j];
//                int x = j * spriteWidth;
//                int y = i * spriteHeight;
//                if (sprite.getClass().getName().split("\\.")[5].charAt(0) == 'W') {
//                    g2d.drawImage(spriteWall, x, y, spriteWidth, spriteHeight, this);
//                } else {
//                    System.out.println("autre");
//                }
//            }
//        }
    }

}
