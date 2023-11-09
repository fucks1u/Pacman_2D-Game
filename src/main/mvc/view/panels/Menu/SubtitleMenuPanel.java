package src.main.mvc.view.panels.Menu;

import javax.swing.*;
import java.awt.*;

/**
 * This class is a JPanel that contains the subtitle of the game.
 */
public class SubtitleMenuPanel extends JPanel {
    public SubtitleMenuPanel() {
        JLabel label = new JLabel("EPITECH SPECIAL EDITION");
        label.setFont(new Font("Arial", Font.BOLD, 35));
        label.setForeground(Color.YELLOW);

        this.setBackground(Color.RED);
        this.add(label);
    }
}
