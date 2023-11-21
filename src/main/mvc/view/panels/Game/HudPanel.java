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
    private DetailsScore detailsScore;
    private CommandsGamePanel commandsPanel;
    /**
     * Constructor of the HudPanel class.
     * It creates the JPanel and add the components.
     * It contains the main Game frame.
     * It contains the commands of the game.
     * It contains the score of the game.
     * It contains the life of the player.
     */
    public HudPanel(int numberOfLife) {
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        this.commandsPanel = new CommandsGamePanel();
        this.scorePanel = new ScorePanel();
        this.detailsScore = new DetailsScore(numberOfLife);

        this.add(commandsPanel);
        this.add(scorePanel);
        this.add(detailsScore);

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
        this.scorePanel.setHighscore(highscore);
    }

    /**
     * This method updates the life of the player.
     * @param life the life of the player.
     */
    public void updateLife(int life) {
        this.detailsScore.getLifeRemaining().updateLife(life);
    }

    /**
     * This method return the details score panel.
     * @return the details score panel.
     */
    public DetailsScore getDetailsScore() {
        return this.detailsScore;
    }
}
