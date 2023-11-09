package src.main.mvc.view.panels.Game;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;

public class HudPanel extends JPanel {
    public HudPanel(){
        this.setBackground(Color.RED);
        this.setPreferredSize(new Dimension(800, 170));
    }
}
