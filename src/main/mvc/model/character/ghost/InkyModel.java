package src.main.mvc.model.character.ghost;

import java.util.List;

import src.main.mvc.model.character.GhostModel;
import src.main.mvc.model.map.MapModel;
import src.main.mvc.utils.Astar.Point;
import src.main.mvc.utils.Astar;

/**
 * This class represents the model of the Ghost Inky in the game.
 * It extends the GhostModel class and implements the movement logic for Inky.
 */
public class InkyModel extends GhostModel {
  public InkyModel(java.awt.Point position) {
    super("Inky", position);
  }

  /**
   * Moves the InkyModel based on the position of the PacmanModel.
   * Inky try to get Pacman between him and Blinky.
   * 
   * @param pacman the PacmanModel used to determine Inky movement.
   */
  public void move(java.awt.Point target, MapModel map, List<java.awt.Point> ghostModels) {
    java.awt.Point currentPos = this.getPosition();

    Point start = new Point((int) currentPos.getX(), (int) currentPos.getY(), null);
    Point end = new Point((int) target.getX(),
        (int) target.getY(), null);
    List<Point> test = Astar.findPathWithGhosts(map, start, end, ghostModels);
    if (test != null) {
      Point nextCell = test.get(0);
      if (nextCell.x > currentPos.getX() && nextCell.y == currentPos.getY()) {
        moveRight();
      } else if (nextCell.x < currentPos.getX() && nextCell.y == currentPos.getY()) {
        moveLeft();
      } else if (nextCell.x == currentPos.getX() && nextCell.y > currentPos.getY()) {
        moveDown();
      } else if (nextCell.x == currentPos.getX() && nextCell.y < currentPos.getY()) {
        moveUp();
      }
    }
  }

  @Override
  public void move(java.awt.Point target, MapModel map) {
    java.awt.Point currentPos = this.getPosition();

    Point start = new Point((int) currentPos.getX(), (int) currentPos.getY(), null);
    Point end = new Point((int) target.getX(),
        (int) target.getY(), null);
    List<Point> test = Astar.findPath(map, start, end);
    if (test != null) {
      Point nextCell = test.get(0);
      if (nextCell.x > currentPos.getX() && nextCell.y == currentPos.getY()) {
        moveRight();
      } else if (nextCell.x < currentPos.getX() && nextCell.y == currentPos.getY()) {
        moveLeft();
      } else if (nextCell.x == currentPos.getX() && nextCell.y > currentPos.getY()) {
        moveDown();
      } else if (nextCell.x == currentPos.getX() && nextCell.y < currentPos.getY()) {
        moveUp();
      }
    }
  }
}
