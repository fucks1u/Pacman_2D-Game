package src.main.mvc.view.frames;

import src.main.mvc.view.panels.*;

import javax.swing.*;
import java.awt.*;

/**
 * This class is a JFrame that contains the menu of the game.
 * It contains the title and the subtitle of the game and buttons.
 * The interface when you launch the game.
 */
public class MenuFrame extends JFrame {
    public MenuFrame() {
        super("Pacman Game");

        //create JPanel to add all the components
        JPanel mainpanel = new JPanel();

        mainpanel.setLayout(new FlowLayout());

        //JPanel for the title -> "PAC-MAN"
        JPanel panelTitle = new TitleMenuPanel();
        panelTitle.setPreferredSize(new Dimension(800, 180));
        mainpanel.add(panelTitle);
        ((FlowLayout) mainpanel.getLayout()).setVgap(0);

        //JPanel for the subtitle -> "EPITECH SPECIAL EDITION"
        JPanel SubtitlePanel = new SubtitleMenuPanel();
        SubtitlePanel.setPreferredSize(new Dimension(600, 50));
        mainpanel.add(SubtitlePanel);

        mainpanel.setBackground(Color.BLACK);

        add(mainpanel);
        setSize(800, 800);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setFocusable(true);
    }
}
