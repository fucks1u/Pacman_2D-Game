package src.main.mvc.view.frames;

import src.main.mvc.view.panels.Game.GamePanel;
import src.main.mvc.view.panels.Game.HudPanel;
import src.main.mvc.view.panels.Menu.ButtonsMenuPanel;
import src.main.mvc.view.panels.Menu.CreditMenuPanel;
import src.main.mvc.view.panels.Menu.SubtitleMenuPanel;
import src.main.mvc.view.panels.Menu.TitleMenuPanel;
import src.main.mvc.view.panels.Score.ButtonNewPlayer;
import src.main.mvc.view.panels.Score.LeaderboardPanel;
import src.main.mvc.view.panels.Score.ScorePanel;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.BoxLayout;
import javax.swing.BorderFactory;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.Component;
import java.io.*;

/**
 * This class is a JFrame that contains the menu of the game.
 * It contains the title and the subtitle of the game and buttons.
 * The interface when you launch the game.
 */
public class MenuFrame extends JFrame implements ActionListener {
    /**
     * This constructor creates the JFrame.
     * It calls the method displayMenu().
     * Call displayMenu to show the default Menu.
     */
    public MenuFrame() {
        super("Pacman Game");
        displayMenu();
    }

    /**
     * This method displays the menu of the game.
     * It contains the title and the subtitle of the game and buttons.
     * The interface when you launch the game.
     */
    public void displayMenu() {
        //create JPanel to add all the components.
        JPanel mainpanel = new JPanel();
        mainpanel.setLayout(new FlowLayout());
        ((FlowLayout) mainpanel.getLayout()).setVgap(0);

        //JPanel for the title -> "PAC-MAN".
        JPanel paneltitle = new TitleMenuPanel();
        paneltitle.setPreferredSize(new Dimension(800, 180));

        //JPanel for the subtitle -> "EPITECH SPECIAL EDITION".
        JPanel subtitlepanel = new SubtitleMenuPanel();
        subtitlepanel.setPreferredSize(new Dimension(600, 50));

        JPanel buttonspanel = new ButtonsMenuPanel();
        buttonspanel.setPreferredSize(new Dimension(400, 350));
        buttonspanel.setBorder(BorderFactory.createEmptyBorder(100, 0, 0, 0));
        for (Component c : buttonspanel.getComponents()) {
            ((JButton) c).addActionListener(this);
        }

        JPanel creditpanel = new CreditMenuPanel();
        creditpanel.setPreferredSize(new Dimension(800, 185));
        creditpanel.setBorder(BorderFactory.createEmptyBorder(160, 420, 0, 0));

        mainpanel.add(paneltitle);
        mainpanel.add(subtitlepanel);
        mainpanel.setBackground(Color.BLACK);
        mainpanel.add(buttonspanel);
        mainpanel.add(creditpanel);

        add(mainpanel);
        setSize(800, 800);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        setFocusable(true);
    }

    /**
     * This method displays the game.
     * It contains the game and the HUD.
     * The interface when you click on the "Play" button.
     */
    public void displayGame() {
        JPanel mainpanel = new JPanel(new FlowLayout());
        ((FlowLayout) mainpanel.getLayout()).setVgap(0);

        mainpanel.add(new GamePanel());
        mainpanel.add(new HudPanel());

        add(mainpanel);
        setSize(800, 800);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        setFocusable(true);
    }

    /**
     * This method displays the interface for the scoreboard.
     * It displays the scoreboard.
     * The interface when you click on the "Score" button.
     */
    public void displayScore() {
        JPanel mainpanel = new JPanel();
        mainpanel.setLayout(new BoxLayout(mainpanel, BoxLayout.Y_AXIS));
        mainpanel.setBorder(null);

        mainpanel.add(new ScorePanel());
        LeaderboardPanel leaderboardPanel = new LeaderboardPanel();
        mainpanel.add(leaderboardPanel);

        JScrollPane scroll = new JScrollPane(leaderboardPanel);
        ButtonNewPlayer buttonnewplayer = new ButtonNewPlayer();
        for (Component c : buttonnewplayer.getComponents()) {
            ((JButton) c).addActionListener(this);
        }

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(mainpanel, BorderLayout.NORTH);
        getContentPane().add(scroll, BorderLayout.CENTER);
        getContentPane().add(buttonnewplayer, BorderLayout.SOUTH);

        mainpanel.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.BLACK));
        scroll.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.BLACK));
        scroll.getVerticalScrollBar().setUnitIncrement(12);
        buttonnewplayer.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.BLACK));

        pack();

        setSize(800, 800);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        setFocusable(true);
    }

    /**
     * This method adds a player to the leaderboard.
     * It writes in the file leaderboard.txt the name given in parameter.
     *
     * @param name
     */
    public void addPlayer(String name) {
        File file = new File("src/main/resources/leaderboard.txt");

        if (file.exists()) {
            if (file.exists()) {
                try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                    String line = reader.readLine();

                    if (line != null) {
                        try {
                            BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));
                            bw.write("\n" + name + ":0");
                            bw.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } else {
                        try {
                            BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));
                            bw.write(name + ":0");
                            bw.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                } catch (IOException e) {
                    System.err.println(e.getMessage());
                }
            } else {
                System.out.println("pas de fichier");
            }
        }
    }


    /**
     * This method is used to know which button is clicked.
     * It is used to know which action to do.
     */
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        String key = actionEvent.getActionCommand();

        switch(key){
            case "New Player":
                String name = JOptionPane.showInputDialog(this, "What's your name?", "New Player", JOptionPane.QUESTION_MESSAGE);
                if(name == null){
                    this.getContentPane().removeAll();
                    this.displayScore();
                    break;
                }
                while(name.isEmpty() || name.length() > 25 || name.charAt(0) == ' ' || name.matches(".*[.,;:?!/].*")){
                    JOptionPane.showMessageDialog(this, String.format("Your name must :%n - have between 1 and 25 caracters %n - not begin with a space %n - not contains special characters(.,;:?!/)."), "Error", JOptionPane.ERROR_MESSAGE);
                    name = JOptionPane.showInputDialog(this, "What's your name?", "New Player", JOptionPane.QUESTION_MESSAGE);
                    if (name == null) {
                        this.getContentPane().removeAll();
                        this.displayScore();
                        break;
                    }
                }
                this.addPlayer(name);
                this.getContentPane().removeAll();
                this.displayScore();
                break;

            case "Back":
                this.getContentPane().removeAll();
                this.displayMenu();
                break;
            case "Play":
                this.getContentPane().removeAll();
                this.displayGame();
                break;
            case "Score":
                this.getContentPane().removeAll();
                this.displayScore();
                break;
            case "Quit":
                System.exit(0);
                break;
            default:
                break;
        }
    }
}
