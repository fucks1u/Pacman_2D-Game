package src.main.mvc.view.panels.Game;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;

/**
 * This class is a JPanel to show HUD for the game.
 * It contains the HUD interface (Life, Score, etc.).
 */
public class HudPanel extends JPanel {
    /**
     * Constructor of the HudPanel class.
     */
    public HudPanel() {
        this.setBackground(Color.RED);
        this.setPreferredSize(new Dimension(800, 170));
    }
}
