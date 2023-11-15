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
    private CommandsGamePanel panelCommands;
    private ScorePanel panelScore;
    private DetailsScore panelLife;

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
        panelCommands = new CommandsGamePanel();
        panelScore = new ScorePanel(0, 0);
        panelLife = new DetailsScore(3);

        this.add(panelCommands);
        this.add(panelScore);
        this.add(panelLife);

        this.setBackground(Color.BLACK);
        this.setPreferredSize(new Dimension(800, 170));
    }

    public void setTimer(int minutes, int seconds) {
        panelLife.setTimer(minutes, seconds);
    }
    public void setScore(int score) {
        panelScore.setScore(score);
    }
    /**
     * Getter of the CommandsGamePanel.
     * @return the CommandsGamePanel.
     */
    public CommandsGamePanel getCommandsGamePanel() {
        return (CommandsGamePanel) this.getComponent(0);
    }

    /**
     * Getter of the ScorePanel.
     * @return the ScorePanel.
     */
    public ScorePanel getScorePanel() {
        return (ScorePanel) this.getComponent(1);
    }

    /**
     * Getter of the DetailsScore.
     * @return the DetailsScore.
     */
    public DetailsScore getPanelLife() {
        return panelLife;
    }
}
