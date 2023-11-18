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
    private ScorePanel scorePanel;
    private DetailsScore panelLife;
    private CommandsGamePanel commandsPanel;
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
        this.commandsPanel = new CommandsGamePanel();
        this.scorePanel = new ScorePanel();
        this.panelLife = new DetailsScore(3);

        this.add(commandsPanel);
        this.add(scorePanel);
        this.add(panelLife);

        this.setBackground(Color.BLACK);
        this.setPreferredSize(new Dimension(800, 170));
    }

    /**
     * This method updates the score of the game.
     * @param score the score of the game.
     */
    public void updateScore(int score) {
        this.scorePanel.setScore(score);
    }

    /**
     * This method updates the highscore of the game.
     * @param highscore the highscore of the game.
     */
    public void updateHighscore(int highscore) {
        ScorePanel scorePanel = (ScorePanel) this.getComponent(1);
        scorePanel.setHighscore(highscore);
    }
}
