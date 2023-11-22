package src.main.mvc.view.panels.Menu;

import javax.swing.JPanel;

import java.awt.Color;

import javax.swing.JComboBox;

public class DifficultyDropdownMenuPanel extends JPanel {
  private JComboBox<String> comboBox;

  public DifficultyDropdownMenuPanel() {
    this.comboBox = new JComboBox<>();

    comboBox.addItem("Easy");
    comboBox.addItem("Medium");
    comboBox.addItem("Hard");
    comboBox.setSelectedIndex(1);
    this.add(comboBox);
    this.setBackground(Color.BLACK);
  }

  public String getDifficulty() {
    return this.comboBox.getSelectedItem().toString();
  }
}
