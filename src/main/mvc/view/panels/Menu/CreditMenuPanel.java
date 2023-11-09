package src.main.mvc.view.panels.Menu;

import java.awt.Color;
import javax.swing.JPanel;
import java.awt.Font;
import javax.swing.JLabel;

public class CreditMenuPanel extends JPanel {
    public CreditMenuPanel() {
        JLabel label = new JLabel("CREDITS : Ariirau FUCKS / Thomas LOUBAT");
        label.setFont(new Font("Arial", Font.BOLD, 15));
        label.setForeground(Color.YELLOW);
        this.setBackground(Color.BLACK);
        this.add(label);
    }
}
