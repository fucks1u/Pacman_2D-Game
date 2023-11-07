import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class PanelTools extends JPanel implements ActionListener {
    public PanelTools() {
        super();
        this.setBackground(Color.BLUE);
        this.setLayout(new BorderLayout());

        JPanel panel = new JPanel();

        panel.setLayout(new BorderLayout());

        JButton b1 = new JButton("Haut");
        b1.addActionListener(this);
        JButton b2 = new JButton("Bas");
        b2.addActionListener(this);
        JButton b3 = new JButton("Gauche");
        b3.addActionListener(this);
        JButton b4 = new JButton("Droite");
        b4.addActionListener(this);

        panel.add(b1, BorderLayout.NORTH);
        panel.add(b2, BorderLayout.SOUTH);
        panel.add(b3, BorderLayout.WEST);
        panel.add(b4, BorderLayout.EAST);

        this.add(panel, BorderLayout.WEST);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        switch(actionEvent.getActionCommand()){
            case "Haut":
                System.out.println("Haut");
                break;
            case "Bas":
                System.out.println("Bas");
                break;
            case "Gauche":
                System.out.println("Gauche");
                break;
            case "Droite":
                System.out.println("Droite");
                break;
        }
    }
}
