package src.main.mvc.view.panels.Menu;

import javax.swing.*;
import java.awt.*;


public class CreditMenuPanel extends JPanel {
    public CreditMenuPanel() {
        JLabel label = new JLabel("CREDITS : Ariirau FUCKS / Thomas LOUBAT");
        label.setFont(new Font("Arial", Font.BOLD, 15));
        label.setForeground(Color.YELLOW);

        this.setBackground(Color.BLACK);
        this.add(label);
    }
}
