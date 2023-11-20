package src.main.mvc.model.character.ghost;

import java.util.ArrayList;
import java.util.List;

import src.main.mvc.model.character.GhostModel;
import src.main.mvc.model.item.ItemModel;
import src.main.mvc.model.item.WallModel;
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
      if (path.size() < 10) {
        nextCell = moveBackward(start, nextCell, map);
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

  private Point moveBackward(Point start, Point nextCell, MapModel map) {
    Point cell = new Point(nextCell.x, nextCell.y, nextCell);
    List<Point> availableCells = getAvailableCell(start, map.getMap());

    if (cell.x > start.x && cell.y == start.y && checkCell(new Point(cell.x - 2, cell.y, cell), map.getMap())) {
      cell = new Point(cell.x - 2, cell.y, start); // Left
    } else if (cell.x < start.x && cell.y == start.y && checkCell(new Point(cell.x + 2, cell.y, cell), map.getMap())) {
      cell = new Point(cell.x + 2, cell.y, start); // Right
    } else if (cell.x == start.x && cell.y > start.y && checkCell(new Point(cell.x, cell.y - 2, cell), map.getMap())) {
      cell = new Point(cell.x, cell.y - 2, start); // Up
    } else if (cell.x == start.x && cell.y < start.y && checkCell(new Point(cell.x, cell.y + 2, cell), map.getMap())) {
      cell = new Point(cell.x, cell.y + 2, start); // Down
    } else {
      for (Point available : availableCells) {
        if (available.x != nextCell.y && available.y != nextCell.y) {
          cell = available;
        }
      }
    }

    return cell;
  }

  private boolean checkCell(Point cell, ItemModel[][] map) {
    if (map[cell.x][cell.y] instanceof WallModel) {
      return false;
    }
    return true;
  }

  private List<Point> getAvailableCell(Point cell, ItemModel[][] map) {
    List<Point> cellList = new ArrayList<>();
    Point right = new Point(cell.x + 1, cell.y, cell);
    Point left = new Point(cell.x - 1, cell.y, cell);
    Point up = new Point(cell.x, cell.y - 1, cell);
    Point down = new Point(cell.x, cell.y + 1, cell);

    if (checkCell(right, map))
      cellList.add(right);
    if (checkCell(left, map))
      cellList.add(left);
    if (checkCell(up, map))
      cellList.add(up);
    if (checkCell(down, map))
      cellList.add(down);

    return cellList;
  }
}
