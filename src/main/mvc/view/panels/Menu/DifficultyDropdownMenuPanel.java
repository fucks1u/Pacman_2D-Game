package src.main.mvc.view.panels.Menu;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JComboBox;

/**
 * This class represents a panel that contains a dropdown menu for selecting
 * difficulty levels.
 */
public class DifficultyDropdownMenuPanel extends JPanel {

  private JComboBox<String> comboBox;

  /**
   * Constructs a new DifficultyDropdownMenuPanel.
   * Initializes the dropdown menu with three difficulty options: Easy, Medium,
   * and Hard.
   * Sets the default selected index to Medium.
   * Sets the background color of the panel to black.
   */
  public DifficultyDropdownMenuPanel() {
    this.comboBox = new JComboBox<>();

    comboBox.addItem("Easy");
    comboBox.addItem("Medium");
    comboBox.addItem("Hard");
    comboBox.setSelectedIndex(1);
    this.add(comboBox);
    this.setBackground(Color.BLACK);
  }

  /**
   * Returns the selected difficulty as a string.
   *
   * @return the selected difficulty as a string
   */
  public String getDifficulty() {
    return this.comboBox.getSelectedItem().toString();
  }
}
