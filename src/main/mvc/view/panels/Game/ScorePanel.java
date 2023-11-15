package src.main.mvc.view.panels.Game;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Component;

/**
 * This class is a JPanel to show the score of the game.
 * It contains the score of the game and the highest score.
 */
public class ScorePanel extends JPanel {

    /**
     * Constructor of the ScorePanel class.
     * It creates the JPanel and add the components.
     * It contains the score of the game.
     * It contains the highest score.
     *
     * @param score     Score of the player.
     * @param highScore Highest score of the player.
     */
    public ScorePanel(int score, int highScore) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setPreferredSize(new Dimension(400, 170));
        setBackground(Color.BLACK);

        JLabel scorelabel = new JLabel("Score : " + score);
        scorelabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        scorelabel.setFont(new Font("Arial", Font.PLAIN, 30));
        scorelabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0));
        scorelabel.setForeground(Color.WHITE);
        this.add(scorelabel);

        JLabel highlabel = new JLabel("Highest Score : " + highScore);
        highlabel.setFont(new Font("Arial", Font.PLAIN, 30));
        highlabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        highlabel.setForeground(Color.GREEN);
        this.add(highlabel);
    }

    public void setScore(int score) {
        JLabel scorepanel = (JLabel) this.getComponent(0);
        scorepanel.setText("Score : " + score);
    }
}
