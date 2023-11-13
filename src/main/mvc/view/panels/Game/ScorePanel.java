package src.main.mvc.view.panels.Game;

import javax.swing.*;
import java.awt.*;

public class ScorePanel extends JPanel {

    public ScorePanel(int score, int highScore) {
            setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
            setPreferredSize(new Dimension(400, 170));
            setBackground(Color.BLACK);

            JLabel scorelabel = new JLabel("Score : "+ score);
            scorelabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            scorelabel.setFont(new Font("Arial", Font.PLAIN, 30));
            scorelabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0));
            scorelabel.setForeground(Color.WHITE);
            this.add(scorelabel);

            JLabel highlabel = new JLabel("Highest Score : "+ highScore);
            highlabel.setFont(new Font("Arial", Font.PLAIN, 30));
            highlabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            highlabel.setForeground(Color.GREEN);
            this.add(highlabel);
        }
}
