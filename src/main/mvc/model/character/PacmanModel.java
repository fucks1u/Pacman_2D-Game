package src.main.mvc.model.character;

import java.awt.Point;

/**
 * Represents the Pacman character in the game.
 */
public class PacmanModel extends CharacterModel {
  private int lives;

  public PacmanModel(Point position) {
    super(position);
    this.lives = 0;
  }

  /**
   * Returns the number of lives Pacman has.
   *
   * @return the number of lives Pacman has.
   */
  public int getLives() {
    return this.lives;
  }

  /**
   * Sets the number of lives for the Pacman character.
   * 
   * @param lives the number of lives to set.
   */
  public void setLives(int lives) {
    this.lives = lives;
  }
}
