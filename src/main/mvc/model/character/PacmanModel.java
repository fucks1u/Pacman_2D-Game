package src.main.mvc.model.character;

import java.awt.Point;

import src.main.mvc.utils.NoSuchDirectionException;

/**
 * Represents the Pacman character in the game.
 */
public class PacmanModel extends CharacterModel {
  private int lives;
  private String direction;

  public PacmanModel(Point position) {
    super(position);
    this.lives = 1;
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

  public void setDirection(String direction) throws NoSuchDirectionException {
    switch (direction) {
      case "up":
        this.direction = "up";
      case "down":
        this.direction = "down";
      case "left":
        this.direction = "left";
      case "right":
        this.direction = "right";
      default:
        throw new NoSuchDirectionException("Wrong direction (up, down, left, right).");
    }
  }

  public String getDirection() {
    return this.direction;
  }
}
