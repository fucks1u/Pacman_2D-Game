package src.main.mvc.view.panels.Menu;

import java.awt.Color;
import javax.swing.JPanel;
import java.awt.Font;
import javax.swing.JLabel;

/**
 * This class is a JPanel that contains the subtitle of the game.
 */
public class SubtitleMenuPanel extends JPanel {
    /**
     * Constructor of the SubtitleMenuPanel class.
     */
    public SubtitleMenuPanel() {
        JLabel label = new JLabel("EPITECH SPECIAL EDITION");
        label.setFont(new Font("Arial", Font.BOLD, 35));
        label.setForeground(Color.YELLOW);

        this.setBackground(Color.RED);
        this.add(label);
    }
}
