package src.main.mvc.view.panels.Game;

import javax.swing.JPanel;
import javax.swing.BorderFactory;
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
        buttonUp.setBackground(Color.DARK_GRAY);
        buttonUp.setForeground(Color.YELLOW);
        buttonUp.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        JButton buttonLeft = new ArrowButton("left");
        buttonLeft.setBackground(Color.DARK_GRAY);
        buttonLeft.setForeground(Color.YELLOW);
        buttonLeft.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        JButton buttonRight = new ArrowButton("right");
        buttonRight.setBackground(Color.DARK_GRAY);
        buttonRight.setForeground(Color.YELLOW);
        buttonRight.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        JButton buttonDown = new ArrowButton("down");
        buttonDown.setBackground(Color.DARK_GRAY);
        buttonDown.setForeground(Color.YELLOW);
        buttonDown.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));

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
