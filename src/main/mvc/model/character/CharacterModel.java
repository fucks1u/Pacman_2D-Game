package src.main.mvc.model.character;

import java.awt.Point;

/**
 * An abstract class representing a character in a 2D space with a position and movement methods.
 */
public abstract class CharacterModel {
  private Point position;

  public CharacterModel(Point position) {
    this.position = position;
  }

  /**
   * Represents a point in 2D space with x and y coordinates.
   */
  public Point getPosition() {
    return this.position;
  }

  /**
   * Moves the character up by decrementing its Y coordinate.
   */
  public void moveUp() {
    this.position.setLocation(this.position.getX(), this.position.getY() - 1);
  }

  /**
   * Moves the character down by incrementing its Y coordinate.
   */
  public void moveDown() {
    this.position.setLocation(this.position.getX(), this.position.getY() + 1);
  }

  /**
   * Moves the character left by decrementing its X coordinate.
   */
  public void moveLeft() {
    this.position.setLocation(this.position.getX() - 1, this.position.getY());
  }

  /**
   * Moves the character right by incrementing its X coordinate.
   */
  public void moveRight() {
    this.position.setLocation(this.position.getX() + 1, this.position.getY());
  }

/**
   * Sets the position of the character.
   * @param position the position to set
   */
    public void setPosition(Point position) {
      this.position = position;
    }
}