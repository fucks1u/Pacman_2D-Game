package src.main.mvc.model.character;

import src.main.mvc.model.item.ItemModel;
import src.main.mvc.model.map.MapModel;

import java.awt.Point;

/**
 * An abstract class representing a character in a 2D space with a position and movement methods.
 */
public abstract class CharacterModel extends ItemModel {
  private Point position;
  private MapModel map;

  public CharacterModel(Point position, MapModel map) {
    super(0);
    this.map = map;
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
    this.map.setCellPacman(this.position,new Point(this.position.x, this.position.y+1));
  }
}