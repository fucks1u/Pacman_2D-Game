package src.main.mvc.view.panels.Menu;

import java.awt.Color;
import javax.swing.JPanel;
import java.awt.Font;
import javax.swing.JLabel;

/**
 * This class is a JPanel that contains our names.
 */
public class CreditMenuPanel extends JPanel {
    /**
     * Constructor of the CreditMenuPanel class
     * It contains a JLabel with our names
     */
    public CreditMenuPanel() {
        JLabel label = new JLabel("CREDITS : Ariirau FUCKS / Thomas LOUBAT");
        label.setFont(new Font("Arial", Font.BOLD, Integer.valueOf("15")));
        label.setForeground(Color.YELLOW);
        this.setBackground(Color.BLACK);
        this.add(label);
    }
}
