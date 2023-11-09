package src.main.mvc.view.panels.Score;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JLabel;
import java.awt.Font;

/**
 * This class is a JPanel to show the ScoreBoard of all registered users.
 * It reads the file leaderboard.txt and displays the players.
 */
public class LeaderboardPanel extends JPanel {
    /**
     * Constructor of the LeaderboardPanel class.
     * It creates the JPanel and adds the players.
     */
    public LeaderboardPanel() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBackground(Color.BLACK);

        addPlayer();
    }

    /**
     * This method adds the players to the leaderboard.
     * It reads the file leaderboard.txt and displays the players.
     * The first player is displayed in red, the second in cyan, the third in orange and the others in pink.
     */
    public void addPlayer(){
        try {
            String fileName = "src/main/resources/leaderboard.txt";
            File file = new File(fileName);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line;
            int i = 1;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(":");
                if (i == 1) {
                    JLabel label = new JLabel(String.format("%s. %s : %s points!!!", i, parts[0], parts[1]));
                    label.setFont(new Font("Arial", Font.BOLD, 60));
                    label.setForeground(Color.RED);
                    add(label);
                    i++;
                } else if (i == 2) {
                    JLabel label = new JLabel(String.format("%s. %s : %s points!!", i, parts[0], parts[1]));
                    label.setFont(new Font("Arial", Font.BOLD, 50));
                    label.setForeground(Color.CYAN);
                    add(label);
                    i++;
                } else if (i == 3) {
                    JLabel label = new JLabel(String.format("%s. %s : %s points!", i, parts[0], parts[1]));
                    label.setFont(new Font("Arial", Font.BOLD, 40));
                    label.setForeground(Color.ORANGE);
                    add(label);
                    i++;
                } else {
                    JLabel label = new JLabel(String.format("%s. %s : %s points", i, parts[0], parts[1]));
                    label.setFont(new Font("Arial", Font.BOLD, 30));
                    label.setForeground(Color.PINK);
                    add(label);
                    i++;
                }
            }
            br.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}