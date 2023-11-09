package src.main.mvc.view.panels.Score;

import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;
import java.io.File;
import java.io.IOException;
import javax.swing.*;
import java.awt.FontFormatException;

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
        titlepanel.setBackground(Color.BLACK);

        titlepanel.add(title);

        add(titlepanel);
        this.setBackground(Color.BLACK);
        this.setPreferredSize(new Dimension(800, 120));
    }

    /**
     * This method loads the custom font.
     *
     * @return Return the custom font for PACMAN.
     */
    private Font loadCustomFont() {
        Font customFontPacman;
        try {
            customFontPacman = Font.createFont(Font.TRUETYPE_FONT,
                    new File("src/main/resources/font/PAC-FONT.TTF"));
        } catch (FontFormatException | IOException e) {
            throw new RuntimeException(e);
        }
        return customFontPacman;
    }
}
