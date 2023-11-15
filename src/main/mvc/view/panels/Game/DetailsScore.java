package src.main.mvc.view.panels.Game;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.BorderFactory;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.Font;
import java.io.File;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

/**
 * This class is a JPanel to show the details of the score.
 * It contains the timer, the number of fruits eaten and the number of monsters eaten.
 */
public class DetailsScore extends JPanel {
    int minutes;
    int seconds;
    int fruits;
    int monsters;
    JLabel timerlabel;

    /**
     * Constructor of the DetailsScore class.
     * It creates the JPanel and add the components.
     *
     * @param numberOfLife
     */
    public DetailsScore(int numberOfLife) {
        this.fruits = 0;
        this.monsters = 0;
        setLayout(new BorderLayout());
        JPanel panelStatsTimerNORTH = new JPanel();
        timerlabel = new JLabel("00:00");
        timerlabel.setFont(new Font("Arial", Font.BOLD, 20));
        //center the jlabel in timerlabel
        timerlabel.setHorizontalAlignment(JLabel.CENTER);
        timerlabel.setPreferredSize(new Dimension(200, 40));
        timerlabel.setForeground(Color.WHITE);
        timerlabel.setBorder(BorderFactory.createEmptyBorder(15, 0, 0, 0));

        JLabel fruitslabel = new JLabel("Fruits eatean : "+fruits);
        fruitslabel.setFont(new Font("Arial", Font.BOLD, 15));
        fruitslabel.setForeground(Color.WHITE);
        fruitslabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));

        JLabel monsterslabel = new JLabel("Monsters eaten : "+monsters);
        monsterslabel.setFont(new Font("Arial", Font.BOLD, 15));
        monsterslabel.setForeground(Color.WHITE);
        monsterslabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));

        panelStatsTimerNORTH.add(timerlabel);
        panelStatsTimerNORTH.add(fruitslabel);
        panelStatsTimerNORTH.add(monsterslabel);

        panelStatsTimerNORTH.setPreferredSize(new Dimension(200, 120));
        panelStatsTimerNORTH.setBackground(Color.BLACK);
        add(panelStatsTimerNORTH, BorderLayout.NORTH);
        /**
         * This panel contains the number of life remaining.
         * It contains the cherry icon to show that bounties are available.
         */
        JPanel panelLifeRemainingSOUTH = new JPanel();
        panelLifeRemainingSOUTH.setPreferredSize(new Dimension(200, 50));
        panelLifeRemainingSOUTH.setBackground(Color.BLACK);
        try {
            BufferedImage cherryPict = ImageIO.read(new File("src/main/resources/img/cherry.png"));
            JLabel cherryLabel = new JLabel(new ImageIcon(cherryPict));
            panelLifeRemainingSOUTH.add(cherryLabel);
            cherryLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 8, 22));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        LifeRemaining lifeRemaining = new LifeRemaining(numberOfLife);
        panelLifeRemainingSOUTH.add(lifeRemaining);
        add(panelLifeRemainingSOUTH, BorderLayout.SOUTH);
    }

    public void setTimer(int minutes, int seconds) {
        if(minutes < 10 && seconds < 10) {
            timerlabel.setText("0"+minutes+":0"+seconds);
        } else if(minutes < 10) {
            timerlabel.setText("0"+minutes+":"+seconds);
        } else if(seconds < 10) {
            timerlabel.setText(minutes+":0"+seconds);
        } else {
            timerlabel.setText(+minutes+":"+seconds);
        }
        repaint();
    }

    public void setLives(int lives) {
    }
}
