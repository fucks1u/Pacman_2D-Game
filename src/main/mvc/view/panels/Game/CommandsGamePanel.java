package src.main.mvc.view.panels.Game;

import javax.swing.*;
import java.awt.*;

public class CommandsGamePanel extends JPanel{

    public CommandsGamePanel(){
        setLayout(new GridLayout(3,3));
        JButton buttonUp = new ArrowButton("up");
        JButton buttonLeft = new ArrowButton("left");
        JButton buttonRight = new ArrowButton("right");
        JButton buttonDown = new ArrowButton("down");

        add(new JLabel());
        add(buttonUp);
        add(new JLabel());
        add(buttonLeft);
        add(new JLabel());
        add(buttonRight);
        add(new JLabel());
        add(buttonDown);
        add(new JLabel());

        setPreferredSize(new Dimension(200, 170));
        setBackground(Color.BLACK);
    }
}
