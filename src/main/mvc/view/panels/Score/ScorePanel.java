package src.main.mvc.view.panels.Score;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;

/**
 * This class is a JPanel to show the ScoreBoard of all registered users
 */
public class ScorePanel extends JPanel {
    /**
     * Constructor of the ScorePanel class
     */
    public ScorePanel() {
        this.setBackground(Color.BLUE);
        this.setPreferredSize(new Dimension(800, 768));
    }
}
