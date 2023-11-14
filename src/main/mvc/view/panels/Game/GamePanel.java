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
        BufferedImage spriteDot = null;

        int spriteWidthWall = 19;
        int spriteHeightWall = 19;

        int spriteWidthDot = 10;
        int spriteHeightDot = 10;

        int spriteWidthBDot = 13;
        int spriteHeightBDot = 13;

        try {
            spriteWall = ImageIO.read(new File("src/main/resources/img/wall.png"));
            spriteDot = ImageIO.read(new File("src/main/resources/img/dot.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                int x = j * spriteWidthWall;
                int y = i * spriteHeightWall;
                if(map[i][j] == null) continue;
                switch(map[i][j].getClass().getName().split("\\.")[5].charAt(0)) {
                    case 'W':
                        g2d.drawImage(spriteWall, x, y, spriteWidthWall, spriteHeightWall, this);
                        break;
                    case 'D':
                        g2d.drawImage(spriteDot, x+5, y+5, spriteWidthDot, spriteHeightDot, this);
                        break;
                    case 'B':
                        g2d.drawImage(spriteDot, x+3, y+3, spriteWidthBDot, spriteHeightBDot, this);
                        break;
                    default:
                        break;
                }
            }
        }
    }

}
