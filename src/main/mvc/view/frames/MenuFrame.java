package src.main.mvc.view.frames;

import src.main.mvc.view.panels.Game.GamePanel;
import src.main.mvc.view.panels.Game.HudPanel;
import src.main.mvc.view.panels.Menu.ButtonsMenuPanel;
import src.main.mvc.view.panels.Menu.CreditMenuPanel;
import src.main.mvc.view.panels.Menu.SubtitleMenuPanel;
import src.main.mvc.view.panels.Menu.TitleMenuPanel;
import src.main.mvc.view.panels.Score.ScorePanel;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class is a JFrame that contains the menu of the game.
 * It contains the title and the subtitle of the game and buttons.
 * The interface when you launch the game.
 */
public class MenuFrame extends JFrame implements ActionListener {
    public MenuFrame() {
        super("Pacman Game");
        displayMenu();
        setLocation((Toolkit.getDefaultToolkit().getScreenSize().width  - getSize().width) / 2, (Toolkit.getDefaultToolkit().getScreenSize().height - getSize().height) / 2);
    }

    /**
     * This method displays the menu of the game.
     * It contains the title and the subtitle of the game and buttons.
     * The interface when you launch the game.
     */
    public void displayMenu(){
        //create JPanel to add all the components
        JPanel mainpanel = new JPanel();
        mainpanel.setLayout(new FlowLayout());
        ((FlowLayout) mainpanel.getLayout()).setVgap(0);

        //JPanel for the title -> "PAC-MAN"
        JPanel paneltitle = new TitleMenuPanel();
        paneltitle.setPreferredSize(new Dimension(800, 180));

        //JPanel for the subtitle -> "EPITECH SPECIAL EDITION"
        JPanel subtitlepanel = new SubtitleMenuPanel();
        subtitlepanel.setPreferredSize(new Dimension(600, 50));

        JPanel buttonspanel = new ButtonsMenuPanel();
        buttonspanel.setPreferredSize(new Dimension(400,350));
        buttonspanel.setBorder(BorderFactory.createEmptyBorder(100, 0, 0, 0));
        for(Component c : buttonspanel.getComponents()) {
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
        setVisible(true);
        setFocusable(true);
    }

    /**
     * This method displays the game.
     * It contains the game and the HUD.
     * The interface when you click on the "Play" button.
     */
    public void displayGame(){
        //create JPanel to add all the components
        JPanel mainpanel = new JPanel(new FlowLayout());
        ((FlowLayout) mainpanel.getLayout()).setVgap(0);

        mainpanel.add(new GamePanel());
        mainpanel.add(new HudPanel());

        add(mainpanel);
        setSize(800, 800);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setFocusable(true);
    }

    /**
     * This method displays the interface for the scoreboard.
     * It displays the scoreboard.
     * The interface when you click on the "Score" button.
     */
    public void displayScore(){
        JPanel mainpanel = new JPanel(new FlowLayout());
        ((FlowLayout) mainpanel.getLayout()).setVgap(0);

        mainpanel.add(new ScorePanel());

        add(mainpanel);
        setSize(800, 800);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setFocusable(true);
    }

    /**
     * This method is used to know which button is clicked.
     * It is used to know which action to do.
     * @param actionEvent
     */
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        String key = actionEvent.getActionCommand();

        switch(key){
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
        }
    }
}
