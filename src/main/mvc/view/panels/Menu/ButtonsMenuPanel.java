package src.main.mvc.view.panels.Menu;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Font;
import java.awt.GridLayout;

/**
 * This class is a JPanel that contains the buttons of the menu.
 * It contains the Play, Score and Quit buttons.
 */
public class ButtonsMenuPanel extends JPanel {
    /**
     * Constructor of the ButtonsMenuPanel class.
     * It creates the buttons and add them to the panel.
     * It also sets the background color of the panel.
     * The action listener of each button is manage by the JFrame parent.
     */
    public ButtonsMenuPanel() {
        JButton buttonPlay = new JButton("Play");
        buttonPlay.setFont(new Font("Arial", Font.PLAIN, 40));
        buttonPlay.setBackground(Color.DARK_GRAY);
        buttonPlay.setForeground(Color.YELLOW);
        buttonPlay.setBorder(BorderFactory.createLineBorder(Color.YELLOW, 1));

        JButton buttonScore = new JButton("Score");
        buttonScore.setFont(new Font("Arial", Font.PLAIN, 40));
        buttonScore.setBackground(Color.DARK_GRAY);
        buttonScore.setForeground(Color.YELLOW);
        buttonScore.setBorder(BorderFactory.createLineBorder(Color.YELLOW, 1));

        JButton buttonQuit = new JButton("Quit");
        buttonQuit.setFont(new Font("Arial", Font.PLAIN, 40));
        buttonQuit.setBackground(Color.DARK_GRAY);
        buttonQuit.setForeground(Color.YELLOW);
        buttonQuit.setBorder(BorderFactory.createLineBorder(Color.YELLOW, 1));

        this.setLayout(new GridLayout(3, 1, 0, 10));
        this.add(buttonPlay);
        this.add(buttonScore);
        this.add(buttonQuit);
        this.setBackground(Color.BLACK);
    }
}
