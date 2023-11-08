package src.main.mvc.view.frames;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class MenuFrame extends JFrame {
    public MenuFrame() throws IOException, FontFormatException {
        super("Pacman");

        add(new src.main.mvc.view.panels.TitleMenuPanel());

        setSize(800, 800);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setFocusable(true);
    }
}
