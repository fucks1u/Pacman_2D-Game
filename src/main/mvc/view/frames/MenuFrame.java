package src.main.mvc.view.frames;

import src.main.mvc.model.character.PacmanModel;
import src.main.mvc.model.item.ItemModel;
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
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.BoxLayout;
import javax.swing.BorderFactory;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;

/**
 * This class is a JFrame that contains the menu of the game.
 * It contains the title and the subtitle of the game and buttons.
 * The interface when you launch the game.
 */
public class MenuFrame extends JFrame {

    private ButtonsMenuPanel panelbuttons;
    private ButtonNewPlayer panelnewplayer;
    private GamePanel panelgame;
    private HudPanel panelhud;
    private PacmanModel pacman;


    /**
     * This constructor creates the JFrame.
     * It calls the method displayMenu().
     * Call displayMenu to show the default Menu.
     */
    public MenuFrame(ItemModel[][] map) {
        super("Pacman Game");
        panelgame = new GamePanel(map);
        panelhud = new HudPanel();
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
        mainpanel.setBackground(Color.BLACK);
        ((FlowLayout) mainpanel.getLayout()).setVgap(0);

        //JPanel for the title -> "PAC-MAN".
        TitleMenuPanel paneltitle = new TitleMenuPanel();
        paneltitle.setPreferredSize(new Dimension(800, 180));

        //JPanel for the subtitle -> "EPITECH SPECIAL EDITION".
        SubtitleMenuPanel subtitlepanel = new SubtitleMenuPanel();
        subtitlepanel.setPreferredSize(new Dimension(600, 50));

        ButtonsMenuPanel buttonspanel = new ButtonsMenuPanel();
        buttonspanel.setPreferredSize(new Dimension(400, 350));
        buttonspanel.setBorder(BorderFactory.createEmptyBorder(100, 0, 0, 0));
        this.panelbuttons = buttonspanel;

        CreditMenuPanel creditpanel = new CreditMenuPanel();
        creditpanel.setPreferredSize(new Dimension(800, 185));
        creditpanel.setBorder(BorderFactory.createEmptyBorder(160, 420, 0, 0));

        mainpanel.add(paneltitle);
        mainpanel.add(subtitlepanel);
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

        mainpanel.add(panelgame);
        mainpanel.add(panelhud);

        add(mainpanel);
        mainpanel.setBackground(Color.BLACK);
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
        this.panelnewplayer = buttonnewplayer;

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
     * @param name The name of the player to add.
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
    public ButtonsMenuPanel getButtonsPanel() {
        return this.panelbuttons;
    }

    public ButtonNewPlayer getNewPlayerPanel() {
        return this.panelnewplayer;
    }

    public GamePanel getPanelGame() {
        return this.panelgame;
    }

    public HudPanel getPanelHud() {
        return this.panelhud;
    }

    public PacmanModel getPacman() {
        return this.pacman;
    }
}
