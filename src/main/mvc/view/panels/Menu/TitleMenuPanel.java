package src.main.mvc.view.panels.Menu;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.BorderFactory;
import java.io.File;
import java.io.IOException;
import java.awt.FontFormatException;

/**
 * This class is a JPanel that contains the title of the game.
 */

public class TitleMenuPanel extends JPanel {
    /**
     * Constructor of the TitleMenuPanel class.
     * It contains a JLabel with the title of the game.
     */
    public TitleMenuPanel() {
        Font customFont = loadCustomFont();
        JLabel label = new JLabel("PAC-MAN");
        label.setForeground(Color.YELLOW);

        label.setBorder(BorderFactory.createEmptyBorder(17, 10, 10, 10));
        this.setBorder(BorderFactory.createLineBorder(Color.YELLOW, 5));

        this.setBackground(Color.BLACK);

        label.setFont(customFont.deriveFont(120f));

        this.add(label);
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
