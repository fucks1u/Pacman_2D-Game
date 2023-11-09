package src.main.mvc.view.panels.Game;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;

/**
 * This class is a JPanel to show the game
 * It contains the Game interface
 */
public class GamePanel extends JPanel {
    /**
     * Constructor of the GamePanel class
     */
    public GamePanel() {
        this.setPreferredSize(new Dimension(800, 600));
        this.setBackground(Color.BLACK);
        this.setVisible(true);
    }
}
