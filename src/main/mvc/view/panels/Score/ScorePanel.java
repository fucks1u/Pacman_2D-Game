package src.main.mvc.view.panels.Score;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.swing.*;

/**
 * This class is a JPanel to show the ScoreBoard of all registered users.
 */
public class ScorePanel extends JPanel {
    /**
     * Constructor of the ScorePanel class.
     */
    public ScorePanel() {
        Font customFont = loadCustomFont();

        JPanel titlepanel = new JPanel();
        JLabel title = new JLabel("ScoreBoard");
        title.setFont(customFont.deriveFont(80f));
        title.setForeground(Color.YELLOW);

        titlepanel.add(title);

        add(titlepanel);
        this.setBackground(Color.BLUE);
        this.setPreferredSize(new Dimension(800, 768));
    }

    /**
     * This method loads the custom font.
     *
     * @return Return the custom font for PACMAN.
     */
    private Font loadCustomFont() {
        Font customFontPacman = null;
        try {
            customFontPacman = Font.createFont(Font.TRUETYPE_FONT,
                    new File("src/main/resources/font/PAC-FONT.TTF"));
        } catch (FontFormatException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return customFontPacman;
    }
}
