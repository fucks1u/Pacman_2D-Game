package main.mvc.view.panels;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class TitleMenuPanel extends JPanel {
    public TitleMenuPanel() {
        Font customFont = loadCustomFont();
        JLabel label = new JLabel("PAC-MAN");
        label.setForeground(Color.YELLOW);
        this.setBackground(Color.RED);

        label.setFont(customFont.deriveFont(100f));

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
        return customFontPacman;
    }
}
