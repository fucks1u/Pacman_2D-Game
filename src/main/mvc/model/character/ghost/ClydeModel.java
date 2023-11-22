package src.main.mvc.model.character.ghost;

import java.util.List;

import src.main.mvc.model.character.GhostModel;
import src.main.mvc.model.map.MapModel;
import src.main.mvc.utils.Astar.Point;
import src.main.mvc.utils.Astar;

/**
 * This class represents the model of the Ghost Clyde in the game.
 * It extends the GhostModel class and implements the movement logic for Clyde.
 */
public class ClydeModel extends GhostModel {
  public ClydeModel(java.awt.Point position) {
    super("Clyde", position);
  }

  /**
   * Moves the ghost character towards the specified target position on the map.
   * Uses the A* algorithm to find the shortest path to the target position.
   * If a valid path is found, the ghost character moves one step closer to the
   * target position.
   * The ghost character can move up, down, left, or right depending on the next
   * cell in the path.
   *
   * @param target The target position to move towards.
   * @param map    The map model representing the game map.
   */
  @Override
  public void move(java.awt.Point target, MapModel map) {
    java.awt.Point currentPos = this.getPosition();

    Point start = new Point((int) currentPos.getX(), (int) currentPos.getY(), null);
    Point end = new Point((int) target.getX(),
        (int) target.getY(), null);
    List<Point> path = Astar.findPath(map, start, end);
    if (path != null) {
      Point nextCell = path.get(0);
      if (path.size() < 10 || this.vulnerable) {
        nextCell = GhostModel.moveBackward(start, nextCell, map);
      }

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
