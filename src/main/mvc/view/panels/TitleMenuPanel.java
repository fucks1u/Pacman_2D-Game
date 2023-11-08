package src.main.mvc.view.panels;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class TitleMenuPanel extends JPanel {
    public TitleMenuPanel() {
        Font customFont = loadCustomFont();
        // Créez un JLabel avec le texte souhaité et la police personnalisée
        JLabel label = new JLabel("PACMAN");
        label.setFont(customFont.deriveFont(100f));

        // Ajoutez le JLabel à votre JPanel
        this.add(label);
    }

    private Font loadCustomFont() {
        Font customFontPacman = null;
        try {
            customFontPacman = Font.createFont(Font.TRUETYPE_FONT, new File("src/main/resources/font/PAC-FONT.TTF"));
        } catch (FontFormatException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        // Ajoutez la police au système de police
        return customFontPacman;
    }
}
