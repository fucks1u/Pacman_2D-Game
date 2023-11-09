package main.mvc.view.frames;

import javax.swing.*;


public class MenuFrame extends JFrame {
    public MenuFrame() {
        super("Pacman");

        add(new main.mvc.view.panels.TitleMenuPanel());

        setSize(800, 800);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setFocusable(true);
    }
}
