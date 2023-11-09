package src.main.mvc.view.panels;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * This class is a JPanel that contains the title of the game.
 */

public class TitleMenuPanel extends JPanel {
    public TitleMenuPanel() {
        Font customFont = loadCustomFont();
        JLabel label = new JLabel("PAC-MAN");
        label.setForeground(Color.YELLOW);

        label.setBorder(BorderFactory.createEmptyBorder(17, 10, 10, 10));
        this.setBorder(BorderFactory.createLineBorder(Color.YELLOW, 5));

        this.setBackground(Color.RED);

        label.setFont(customFont.deriveFont(120f));

        this.add(label);
    }

    /**
     * This method loads the custom font.
     * @return Return the custom font for PACMAN
     */
    private Font loadCustomFont() {
        Font customFontPacman = null;
        try {
            customFontPacman = Font.createFont(Font.TRUETYPE_FONT, new File("src/main/resources/font/PAC-FONT.TTF"));
        } catch (FontFormatException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return customFontPacman;
    }
}
