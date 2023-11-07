import javax.swing.*;
import java.awt.*;

public class Main extends JFrame{
    public Main() {
        GridBagLayout grid = new GridBagLayout();
        this.setLayout(grid);

        PanelTools p1;
        JPanel p2;

        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1;
        c.weighty = 0.2;
        c.gridy = 0;

        p1 = new PanelTools();
        this.getContentPane().add(p1, c);

        p2 = new JPanel();
        c.weighty = 0.6;
        c.gridy = 1;
        getContentPane().add(p2,c);

        pack();
        validate();

        setTitle("Game");
        setVisible(true);
        setSize(800, 800);
        setLocationRelativeTo(null);
    }


    public static void main(String[] args) {
    new Main();
    }
}
