package src.main.mvc.view.panels.Game;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.Timer;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * This class is a JPanel to show the number of life remaining.
 * It contains the heart icon to show the number of life remaining.
 */
public class LifeRemaining extends JPanel {
    /**
     * Constructor of the LifeRemaining class.
     * It creates the JPanel and add the components.
     * It contains the number of life remaining.
     * Each heart icon is a JLabel, it all blinks.
     * 
     * @param numberOfLife Number of life remaining.
     */
    public LifeRemaining(int numberOfLife) {
        try {
            for (int i = 0; i < numberOfLife; i++) {
                BufferedImage heartPict = ImageIO.read(new File("src/main/resources/img/heart_32x32.png"));
                JLabel heartLabel = new JLabel(new ImageIcon(heartPict));
                add(heartLabel);
                Timer timer = new Timer(700, new ActionListener() {
                    private boolean isVisible = true;

                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        isVisible = !isVisible;
                        heartLabel.setVisible(isVisible);
                    }
                });
                timer.start();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        setPreferredSize(new Dimension(120, 50));
        setBackground(Color.BLACK);
    }

    /**
     * This method updates the number of life remaining.
     * 
     * @param numberOfLife
     */
    public void updateLife(int numberOfLife) {
        removeAll();
        try {
            for (int i = 0; i < numberOfLife; i++) {
                BufferedImage heartPict = ImageIO.read(new File("src/main/resources/img/heart_32x32.png"));
                JLabel heartLabel = new JLabel(new ImageIcon(heartPict));
                add(heartLabel);
                Timer timer = new Timer(700, new ActionListener() {
                    private boolean isVisible = true;

                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        isVisible = !isVisible;
                        heartLabel.setVisible(isVisible);
                    }
                });
                timer.start();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        setPreferredSize(new Dimension(120, 50));
        setBackground(Color.BLACK);
    }
}
