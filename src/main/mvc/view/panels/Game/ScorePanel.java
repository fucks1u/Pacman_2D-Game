package src.main.mvc.view.panels.Game;

import javax.swing.*;
import java.awt.*;

public class ScorePanel extends JPanel {

    public ScorePanel(int score, int highScore) {
            setLayout(new BorderLayout());
            setPreferredSize(new Dimension(400, 170));
            setBackground(Color.GREEN);

            JLabel scorelabel = new JLabel("Score : "+ score);
            JLabel highscorelabel = new JLabel("Highscore : "+ highScore);

            scorelabel.setVerticalAlignment(SwingConstants.CENTER);
            highscorelabel.setVerticalAlignment(SwingConstants.CENTER);

            this.add(scorelabel);
            this.add(highscorelabel);
        }
}
