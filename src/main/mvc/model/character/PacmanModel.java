package src.main.mvc.model.character;

import java.awt.Point;

/**
 * Represents the Pacman character in the game.
 */
public class PacmanModel extends CharacterModel {
  private int lives;
  private directions direction;


  public enum directions {
    UP,
    DOWN,
    LEFT,
    RIGHT
  };

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


  public void setDirection(directions direction) {
    switch (direction) {
      case UP:
        this.direction = directions.UP;
        break;
      case DOWN:
        this.direction = directions.DOWN;
        break;
      case LEFT:
        this.direction = directions.LEFT;
        break;
      case RIGHT:
        this.direction = directions.RIGHT;
        break;
    }
  }

  public directions getDirection() {
    return this.direction;
  }

  public void move() {
    switch (this.direction) {
      case UP:
        this.moveUp();
        break;
      case DOWN:
        this.moveDown();
        break;
      case LEFT:
        this.moveLeft();
        break;
      case RIGHT:
        this.moveRight();
        break;
      default:
        return;
    }
  }
}
