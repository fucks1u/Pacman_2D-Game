package src.main.mvc.view.panels;

import javax.swing.*;
import java.awt.*;

/**
 * This class is a JPanel that contains the subtitle of the game.
 */
public class SubtitleMenuPanel extends JPanel {
    public SubtitleMenuPanel() {
        JLabel label = new JLabel("EPITECH SPECIAL EDITION");
        label.setForeground(Color.YELLOW);

        this.setBackground(Color.BLACK);

        label.setFont(new Font("Arial", Font.BOLD, 35));

        this.add(label);
    }
}
