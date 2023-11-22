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
    private JLabel scorelabel;
    JLabel highscorelabel;
    /**
     * Constructor of the ScorePanel class.
     * It creates the JPanel and add the components.
     * It contains the score of the game.
     * It contains the highest score.
     */
    public ScorePanel() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setPreferredSize(new Dimension(400, 170));
        setBackground(Color.BLACK);

        this.scorelabel = new JLabel("Score : 0");
        this.scorelabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.scorelabel.setFont(new Font("Arial", Font.PLAIN, 30));
        this.scorelabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0));
        this.scorelabel.setForeground(Color.WHITE);
        this.add(this.scorelabel);

        this.highscorelabel = new JLabel("Highest Score : 0");
        this.highscorelabel.setFont(new Font("Arial", Font.PLAIN, 30));
        this.highscorelabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.highscorelabel.setForeground(Color.GREEN);
        this.add(this.highscorelabel);
    }

    /**
     * This method updates the score of the game.
     * @param score the score of the game.
     */
    public void setScore(int score){
        this.scorelabel.setText("Score : " + score);
        this.repaint();
    }

    /**
     * This method updates the highest score of the game.
     * @param highscore the highest score of the game.
     */
    public void setHighscore(int highscore){
        this.highscorelabel.setText("Highest Score : " + highscore);
        this.repaint();
    }
}
