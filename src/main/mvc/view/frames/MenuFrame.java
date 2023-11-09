package src.main.mvc.view.frames;

import src.main.mvc.view.panels.Menu.ButtonsMenuPanel;
import src.main.mvc.view.panels.Menu.CreditMenuPanel;
import src.main.mvc.view.panels.Menu.SubtitleMenuPanel;
import src.main.mvc.view.panels.Menu.TitleMenuPanel;

import javax.swing.*;
import java.awt.*;
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
    }

    public void displayMenu(){
        //create JPanel to add all the components
        JPanel mainpanel = new JPanel();
        mainpanel.setLayout(new FlowLayout());
        ((FlowLayout) mainpanel.getLayout()).setVgap(0);

        //JPanel for the title -> "PAC-MAN"
        JPanel panelTitle = new TitleMenuPanel();
        panelTitle.setPreferredSize(new Dimension(800, 180));

        //JPanel for the subtitle -> "EPITECH SPECIAL EDITION"
        JPanel SubtitlePanel = new SubtitleMenuPanel();
        SubtitlePanel.setPreferredSize(new Dimension(600, 50));

        JPanel ButtonsPanel = new ButtonsMenuPanel();
        ButtonsPanel.setPreferredSize(new Dimension(400,350));
        ButtonsPanel.setBorder(BorderFactory.createEmptyBorder(100, 0, 0, 0));
        for(Component c : ButtonsPanel.getComponents()) {
            ((JButton) c).addActionListener(this);
        }

        JPanel CreditPanel = new CreditMenuPanel();
        CreditPanel.setPreferredSize(new Dimension(800, 185));
        CreditPanel.setBorder(BorderFactory.createEmptyBorder(160, 420, 0, 0));

        mainpanel.add(panelTitle);
        mainpanel.add(SubtitlePanel);
        mainpanel.setBackground(Color.BLACK);
        mainpanel.add(ButtonsPanel);
        mainpanel.add(CreditPanel);

        add(mainpanel);
        setSize(800, 800);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setFocusable(true);
    }

    public void displayGame(){
        //create JPanel to add all the components
        JPanel mainpanel = new JPanel();
        mainpanel.setLayout(new FlowLayout());
        ((FlowLayout) mainpanel.getLayout()).setVgap(0);

        //JPanel for the title -> "PAC-MAN"
        JPanel panelTitle = new TitleMenuPanel();
        panelTitle.setPreferredSize(new Dimension(800, 180));


        mainpanel.add(panelTitle);

        add(mainpanel);
        setSize(800, 800);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setFocusable(true);
    }

    public void displayScore(){

    }

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
