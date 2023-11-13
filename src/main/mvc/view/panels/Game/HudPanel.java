package src.main.mvc.view.panels.Game;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.BoxLayout;

/**
 * This class is a JPanel to show HUD for the game.
 * It contains some panels to create a main panel.
 */
public class HudPanel extends JPanel {
    /**
     * Constructor of the HudPanel class.
     * It creates the JPanel and add the components.
     * It contains the main Game frame.
     * It contains the commands of the game.
     * It contains the score of the game.
     * It contains the life of the player.
     */
    public HudPanel() {
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        JPanel panelCommands = new CommandsGamePanel();
        JPanel panelScore = new ScorePanel(0, 0);
        JPanel panelLife = new JPanel();

        panelLife.setPreferredSize(new Dimension(200, 170));
        panelLife.setBackground(Color.YELLOW);

        this.add(panelCommands);
        this.add(panelScore);
        this.add(panelLife);

        this.setBackground(Color.BLACK);
        this.setPreferredSize(new Dimension(800, 170));
    }
}
