package src.main.mvc.view.panels.Menu;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Font;
import java.awt.GridLayout;

public class ButtonsMenuPanel extends JPanel {
    public ButtonsMenuPanel() {
        JButton buttonPlay = new JButton("Play");
        buttonPlay.setFont(new Font("Arial", Font.PLAIN, 40));

        JButton buttonScore = new JButton("Score");
        buttonScore.setFont(new Font("Arial", Font.PLAIN, 40));

        JButton buttonQuit = new JButton("Quit");
        buttonQuit.setFont(new Font("Arial", Font.PLAIN, 40));

        this.setLayout(new GridLayout(3, 1, 0, 10));
        this.add(buttonPlay);
        this.add(buttonScore);
        this.add(buttonQuit);
        this.setBackground(Color.BLACK);
    }
}
