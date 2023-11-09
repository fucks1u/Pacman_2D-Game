package src.main.mvc.view.frames;

import src.main.mvc.view.panels.TitleMenuPanel;

import javax.swing.*;
import java.awt.*;


public class MenuFrame extends JFrame {
    public MenuFrame() {
        super("Pacman");
        this.setLayout(new BorderLayout());

        JPanel panelTitle = new TitleMenuPanel();
        panelTitle.setPreferredSize(new Dimension(800, 180));
        add(panelTitle, BorderLayout.NORTH);

        setSize(800, 800);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setFocusable(true);
    }
}
