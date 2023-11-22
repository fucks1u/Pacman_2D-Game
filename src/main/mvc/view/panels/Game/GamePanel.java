package src.main.mvc.view.panels.Game;

import src.main.mvc.model.character.GhostModel;
import src.main.mvc.model.character.PacmanModel;
import src.main.mvc.model.item.ItemModel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

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
    private PacmanModel pacman;
    private List<GhostModel> ghost;
    private int pacmanMouthAngle = 45;
    private boolean mouthOpen = true;




    /**
     * Constructor of the GamePanel class.
     * It creates the JPanel and add the components.
     * It contains the map of the game.
     * It contains the pacman.
     * It contains the ghosts.
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
        /**
         * This timer is used to animate the mouth of pacman.
         */
        Timer timer = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mouthOpen = !mouthOpen;
                repaint();
            }
        });
        timer.start();
    }

    /**
     * This method paints the components.
     * It draws the map.
     * It draws the pacman and animate it.
     * It draws the ghosts.
     * @param g the <code>Graphics</code> object to protect
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;


        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                int x = i * 19;
                int y = j * 19;
                if(map[i][j] == null) continue;
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

    /**
     * This method draws the pacman and animate it.
     * @param g the <code>Graphics</code> object to protect
     * @param angleBouche the angle of the mouth of pacman
     */
    private void dessinerPacman(Graphics g, int angleBouche) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.YELLOW);
        int x = pacman.getPosition().x*19;
        int y = pacman.getPosition().y*19;

        if(pacman.getDirection() == null) {
            g2d.fillArc(x, y, 19, 19, angleBouche, 360 - 2 * angleBouche);
            return;
        }
        switch (pacman.getDirection()) {
            case UP:
                g2d.rotate(Math.toRadians(-90), x+11.5, y+13);
                break;
            case LEFT:
                g2d.rotate(Math.toRadians(180), x+10, y+10);
                break;
            case DOWN:
                g2d.rotate(Math.toRadians(90), x+10.5, y+9);
                break;
        }

        g2d.fillArc(x, y, 19, 19, angleBouche, 360 - 2 * angleBouche);
        g2d.rotate(Math.toRadians(0), x, y);
    }

    /**
     * This method sets the map.
     * It used when the user launch a new game after a game over.
     * @param map the map of the game.
     */
    public void setMap(ItemModel[][] map) {
        this.map = map;
        this.repaint();
    }
}
