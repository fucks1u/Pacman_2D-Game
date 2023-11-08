import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Main extends JFrame implements KeyListener {

    JLabel label;
    public Main() {
        GridBagLayout grid = new GridBagLayout();
        this.setLayout(grid);

        JPanel p2;

        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1;
        c.weighty = 0.2;
        c.gridy = 0;


        p2 = new JPanel();
        c.weighty = 0.6;
        c.gridy = 1;
        getContentPane().add(p2,c);

        ImageIcon image = new ImageIcon("pacman.png");
        label = new JLabel(image);

        p2.add(label);
        pack();
        validate();

        setTitle("Game");
        setVisible(true);
        setSize(1000, 800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setFocusable(true);
        addKeyListener(this);
    }


    public static void main(String[] args) {
        new Main();
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) { }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();

        if(keyCode == KeyEvent.VK_UP){
            label.setLocation(label.getX(), label.getY() - 10);
        }
        if(keyCode == KeyEvent.VK_DOWN){
            label.setLocation(label.getX(), label.getY() + 10);
        }
        if(keyCode == KeyEvent.VK_LEFT){
            label.setLocation(label.getX()-10, label.getY());
        }
        if(keyCode == KeyEvent.VK_RIGHT){
            label.setLocation(label.getX()+10, label.getY());
        }

    }

    @Override
    public void keyReleased(KeyEvent keyEvent) { }
}
