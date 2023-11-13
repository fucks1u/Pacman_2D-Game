package src.main.mvc.view.panels.Game;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Dimension;

/**
 * This class is a JPanel to show the commands of the game.
 * It contains the four buttons to move the player.
 */
public class CommandsGamePanel extends JPanel {

    /**
     * Constructor of the CommandsGamePanel class.
     * It set up the JPanel and add the components.
     * It contains the four buttons to move the player.
     * The four buttons are up, left, right and down.
     * JButton are created with the class {@link ArrowButton}.
     */
    public CommandsGamePanel() {
        setLayout(new GridLayout(3, 3));
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
