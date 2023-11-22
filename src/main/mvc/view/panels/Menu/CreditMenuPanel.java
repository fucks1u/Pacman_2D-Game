package src.main.mvc.view.panels.Menu;

import java.awt.Color;
import javax.swing.JPanel;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;

/**
 * This class is a JPanel that contains our names.
 */
public class CreditMenuPanel extends JPanel {
    private DifficultyDropdownMenuPanel difficultyDropdown;

    /**
     * Constructor of the CreditMenuPanel class.
     * It contains a JLabel with our names.
     */
    public CreditMenuPanel() {
        JLabel label = new JLabel("CREDITS : Ariirau FUCKS / Thomas LOUBAT");
        label.setFont(new Font("Arial", Font.BOLD, Integer.valueOf("15")));
        label.setForeground(Color.YELLOW);
        this.setLayout(new GridLayout(1, 2));
        this.setBackground(Color.BLACK);

        this.difficultyDropdown = new DifficultyDropdownMenuPanel();
        this.add(difficultyDropdown);
        this.add(label);
        label.setBorder(BorderFactory.createEmptyBorder(0, 38, 0, 0));
        this.difficultyDropdown.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 290));
    }

    /**
     * Retrieves the difficulty selected in the credit panel.
     *
     * @return The difficulty selected as a String.
     */
    public String getCreditPanelDifficulty() {
        return this.difficultyDropdown.getDifficulty();
    }
}
