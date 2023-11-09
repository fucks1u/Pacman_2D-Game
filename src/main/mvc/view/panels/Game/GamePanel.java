package src.main.mvc.view.panels.Game;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;
public class GamePanel extends JPanel {
    public GamePanel(){
        this.setPreferredSize(new Dimension(800,600));
        this.setBackground(Color.BLACK);
        this.setVisible(true);
    }
}
