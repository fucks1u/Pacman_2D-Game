package src.main.mvc.view.panels.Game;

import src.main.mvc.model.character.GhostModel;
import src.main.mvc.model.character.PacmanModel;
import src.main.mvc.model.item.ItemModel;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.*;

/**
 * This class is a JPanel to show the game.
 * It contains the Game interface.
 */
public class GamePanel extends JPanel {
    private ItemModel[][] map;

    private BufferedImage spriteWall = null;
    private BufferedImage spriteDot = null;
    private BufferedImage spritePacman = null;
    private BufferedImage spriteBigDot = null;
    private BufferedImage spriteGhost = null;
    private BufferedImage spriteCherry = null;
    private PacmanModel pacman;
    private List<GhostModel> ghost;



    /**
     * Constructor of the GamePanel class.
     */
    public GamePanel(ItemModel[][] map, PacmanModel pacman, List<GhostModel> ghost) {
        this.map = map;
        this.pacman = pacman;
        this.ghost = ghost;
        this.setPreferredSize(new Dimension(600, 590));
        this.setBackground(Color.BLACK);
        this.setVisible(true);
        try {
            spriteWall = ImageIO.read(new File("src/main/resources/img/wall.png"));
            spriteDot = ImageIO.read(new File("src/main/resources/img/dotitem.png"));
            spriteBigDot = ImageIO.read(new File("src/main/resources/img/dot.png"));
            spritePacman = ImageIO.read(new File("src/main/resources/img/pacman.png"));
            spriteGhost = ImageIO.read(new File("src/main/resources/img/ghost3.png"));
            spriteCherry = ImageIO.read(new File("src/main/resources/img/cherry.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;


        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                int x = i * 19;
                int y = j * 19;
                if(map[i][j] == null)  continue;
                switch(map[i][j].getClass().getName().split("\\.")[5].charAt(0)) {
                    case 'W':
                        g2d.drawImage(spriteWall, x, y, 19, 19, this);
                        break;
                    case 'D':
                        g2d.drawImage(spriteDot, x+5, y+5, 10, 10, this);
                        break;
                    case 'B':
                        g2d.drawImage(spriteBigDot, x+4, y+4, 11, 11, this);
                        break;
                    case 'f':
                    g2d.drawImage(spriteCherry, x+4, y+4, 16, 16, this);
                    break;
                    default:
                        break;
                }
            }
        }
        for (GhostModel ghost : this.ghost) {
            g2d.drawImage(spriteGhost, ghost.getPosition().x*19, ghost.getPosition().y*19, 19, 19, this);
        }
        g2d.drawImage(spritePacman, this.pacman.getPosition().x*19, this.pacman.getPosition().y*19, 19, 19, this);
    }

    public void setMap(ItemModel[][] map) {
        this.map = map;
        this.repaint();
    }
}
