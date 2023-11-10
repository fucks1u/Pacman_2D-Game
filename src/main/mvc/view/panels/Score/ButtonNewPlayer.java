package src.main.mvc.view.panels.Score;

import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * This class is a JPanel to show two buttons.
 * The first button is to go back to the menu.
 * The second button is to create a new player.
 */
public class ButtonNewPlayer extends JPanel{

    /**
     * Constructor of the ButtonNewPlayer class.
     */
    public ButtonNewPlayer(){
        this.setLayout(null);

        JButton back = new JButton("Back");
        JButton button = new JButton("New Player");

        button.setPreferredSize(new java.awt.Dimension(200, 50));
        button.setFont(new Font("Arial", Font.BOLD, 16));
        button.setBorder(new EmptyBorder(10, 10, 10, 10));

        back.setBounds(10, 10, 100, 30);
        button.setBounds(300, 25, 200, 50);

        add(back);
        add(button);

        setPreferredSize(new Dimension(800, 100));
        setBackground(Color.BLACK);
    }
}
