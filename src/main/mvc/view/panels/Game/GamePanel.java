package src.main.mvc.view.panels.Game;

import src.main.mvc.model.character.GhostModel;
import src.main.mvc.model.character.PacmanModel;
import src.main.mvc.model.item.ItemModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    private BufferedImage spriteBigDot = null;
    private BufferedImage spriteGhostInky = null; 
    private BufferedImage spriteGhostBlinky = null;
    private BufferedImage spriteGhostPinky = null;
    private BufferedImage spriteGhostClyde = null;
    private BufferedImage spriteGhostVulnerable = null;
    private BufferedImage spriteCherry = null;
    private int i = 0;
    private PacmanModel pacman;
    private List<GhostModel> ghost;
    private int pacmanMouthAngle = 45;
    private boolean mouthOpen = true;




    /**
     * Constructor of the GamePanel class.
     */
    public GamePanel(ItemModel[][] map, PacmanModel pacman, List<GhostModel> ghost) {
        this.map = map;
        this.pacman = pacman;
        this.ghost = ghost;
        this.setPreferredSize(new Dimension(610, 590));
        this.setBackground(Color.BLACK);
        this.setVisible(true);
        try {
            spriteWall = ImageIO.read(new File("src/main/resources/img/wall.png"));
            spriteDot = ImageIO.read(new File("src/main/resources/img/dotitem.png"));
            spriteBigDot = ImageIO.read(new File("src/main/resources/img/dot.png"));
            spriteCherry = ImageIO.read(new File("src/main/resources/img/cherry.png"));
            spriteGhostInky = ImageIO.read(new File("src/main/resources/img/inky.png"));
            spriteGhostBlinky = ImageIO.read(new File("src/main/resources/img/blinky.png"));
            spriteGhostPinky = ImageIO.read(new File("src/main/resources/img/pinky.png"));
            spriteGhostClyde = ImageIO.read(new File("src/main/resources/img/clyde.png"));
            spriteGhostVulnerable = ImageIO.read(new File("src/main/resources/img/vulnerable.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Timer timer = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mouthOpen = !mouthOpen;
                repaint();
            }
        });
        timer.start();
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
            if(ghost.isVulnerable()) {
                g2d.drawImage(spriteGhostVulnerable, ghost.getPosition().x*19, ghost.getPosition().y*19-3, 23, 23, this);
                continue;
            } else {
                switch(ghost.getName()){
                    case "Inky":
                        g2d.drawImage(spriteGhostInky, ghost.getPosition().x*19, ghost.getPosition().y*19-3, 23, 23, this);
                        break;
                    case "Blinky":
                        g2d.drawImage(spriteGhostBlinky, ghost.getPosition().x*19, ghost.getPosition().y*19-3, 23, 23, this);
                        break;
                    case "Pinky":
                        g2d.drawImage(spriteGhostPinky, ghost.getPosition().x*19, ghost.getPosition().y*19-3, 23, 23, this);
                        break;
                    case "Clyde":
                        g2d.drawImage(spriteGhostClyde, ghost.getPosition().x*19, ghost.getPosition().y*19-3, 23, 23, this);
                        break;
                }
            }
        }
        dessinerPacman(g, mouthOpen ? pacmanMouthAngle : 0);
    }

    private void dessinerPacman(Graphics g, int angleBouche) {
        g.setColor(Color.YELLOW);
        g.fillArc(this.pacman.getPosition().x*19, this.pacman.getPosition().y*19, 19, 19, angleBouche, 360 - 2 * angleBouche);
    }

    public void setMap(ItemModel[][] map) {
        this.map = map;
        this.repaint();
    }
}
