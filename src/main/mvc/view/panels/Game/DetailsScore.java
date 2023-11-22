package src.main.mvc.view.panels.Game;

import src.main.mvc.utils.Clock;

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
 * It contains the timer, the number of fruits eaten and the number of monsters
 * eaten.
 */
public class DetailsScore extends JPanel {
    private JLabel timerlabel;
    private JLabel fruitslabel;
    private JLabel monsterslabel;
    private LifeRemaining lifeRemaining;

    /**
     * Constructor of the DetailsScore class.
     * It creates the JPanel and add the components.
     * 
     * @param numberOfLife
     */
    public DetailsScore(int numberOfLife) {
        setLayout(new BorderLayout());
        JPanel panelStatsTimerNORTH = new JPanel();
        timerlabel = new JLabel("Timer : 00:00");
        timerlabel.setFont(new Font("Arial", Font.BOLD, 20));
        timerlabel.setForeground(Color.WHITE);
        timerlabel.setBorder(BorderFactory.createEmptyBorder(15, 0, 0, 0));

        fruitslabel = new JLabel("Fruits eaten : 0");
        fruitslabel.setFont(new Font("Arial", Font.BOLD, 15));
        fruitslabel.setForeground(Color.WHITE);
        fruitslabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));

        monsterslabel = new JLabel("Monsters eaten : 0");
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
            BufferedImage cherryPict = ImageIO.read(new File("src/main/resources/img/fruits/cherry.png"));
            JLabel cherryLabel = new JLabel(new ImageIcon(cherryPict));
            panelLifeRemainingSOUTH.add(cherryLabel);
            cherryLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 8, 22));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        lifeRemaining = new LifeRemaining(numberOfLife);
        panelLifeRemainingSOUTH.add(lifeRemaining);
        add(panelLifeRemainingSOUTH, BorderLayout.SOUTH);
    }

    /**
     * This method updates the timer of the game.
     * 
     * @param timer The timer of the game.
     */
    public void setTimerlabel(Clock timer) {
        long min;
        long sec;
        if (timer == null) {
            this.timerlabel.setText("Timer : 00:00");
            return;
        }
        min = timer.getMin();
        sec = timer.getSec();
        if (timer.getSec() % 60 == 0 && sec > 0) {
            sec -= 60;
        }
        if (min < 10 && sec < 10)
            this.timerlabel.setText("Timer : 0" + min + ":0" + sec);
        else if (min < 10)
            this.timerlabel.setText("Timer : 0" + min + ":" + sec);
        else if (sec < 10)
            this.timerlabel.setText("Timer : " + min + ":0" + sec);
        else
            this.timerlabel.setText("Timer : " + min + ":" + sec);
        this.repaint();
    }

    /**
     * This method updates the number of fruits eaten.
     * 
     * @param fruits The number of fruits eaten.
     */
    public void setFruitslabel(int fruits) {
        this.fruitslabel.setText("Fruits eaten : " + fruits);
        this.repaint();
    }

    /**
     * This method updates the number of monsters eaten.
     * 
     * @param monsters The number of monsters eaten.
     */
    public void setMonsterslabel(int monsters) {
        this.monsterslabel.setText("Monsters eaten : " + monsters);
        this.repaint();
    }

    /**
     * This method returns the JPanel containing the number of life remaining.
     * 
     * @return The JPanel of life remaining.
     */
    public LifeRemaining getLifeRemaining() {
        return this.lifeRemaining;
    }
}
