package src.main.mvc.model.character;

import src.main.mvc.model.item.ItemModel;
import src.main.mvc.model.item.WallModel;
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
    Point nextPos = new Point(this.position.x-1, this.position.y);
    if(this.map.isAccessible(nextPos)){
      this.map.setCell(this.position);
      this.position = nextPos;
      this.map.setCellPacman(this.position);
    }
  }

  /**
   * Moves the character down by incrementing its Y coordinate.
   */
  public void moveDown() {
    Point nextPos = new Point(this.position.x+1, this.position.y);
    if(this.map.isAccessible(nextPos)){
      this.map.setCell(this.position);
      this.position = nextPos;
      this.map.setCellPacman(this.position);
    }
  }

  /**
   * Moves the character left by decrementing its X coordinate.
   */
  public void moveLeft() {
    Point nextPos = new Point(this.position.x, this.position.y-1);
    if(this.map.isAccessible(nextPos)){
      this.map.setCell(this.position);
      this.position = nextPos;
      this.map.setCellPacman(this.position);
    }
  }

  /**
   * Moves the character right by incrementing its X coordinate.
   */
  public void moveRight() {
    Point nextPos = new Point(this.position.x, this.position.y+1);
    if(this.map.isAccessible(nextPos)){
      this.map.setCell(this.position);
      this.position = nextPos;
      this.map.setCellPacman(this.position);
    }
  }

  public boolean canMoveUp(){
    Point nextPos = new Point(this.position.x-1, this.position.y);
    return this.map.isAccessible(nextPos);
  }

  public boolean canMoveDown(){
    Point nextPos = new Point(this.position.x+1, this.position.y);
    return this.map.isAccessible(nextPos);
  }

  public boolean canMoveLeft(){
    Point nextPos = new Point(this.position.x, this.position.y-1);
    return this.map.isAccessible(nextPos);
  }

  public boolean canMoveRight(){
    Point nextPos = new Point(this.position.x, this.position.y+1);
    return this.map.isAccessible(nextPos);
  }
}