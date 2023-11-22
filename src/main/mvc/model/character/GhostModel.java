package src.main.mvc.model.character;

import java.util.ArrayList;
import java.util.List;

import src.main.mvc.model.item.ItemModel;
import src.main.mvc.model.item.WallModel;
import src.main.mvc.model.map.MapModel;
import src.main.mvc.utils.Astar.Point;

/**
 * The GhostModel class represents the abstract model of a ghost character in
 * the game.
 * It extends the CharacterModel class and provides methods to get and set the
 * vulnerability status of the ghost,
 * get the name of the ghost, and move the ghost depending on the Pacman
 * position.
 */
public abstract class GhostModel extends CharacterModel {
  public boolean vulnerable;
  private String name;

  public GhostModel(String name, java.awt.Point position) {
    super(position);
    this.name = name;
    this.vulnerable = false;
  }

  /**
   * Returns whether the ghost is currently vulnerable or not.
   *
   * @return true if the ghost is vulnerable, false otherwise.
   */
  public boolean isVulnerable() {
    return vulnerable;
  }

  /**
   * Sets the vulnerability status of the ghost.
   * 
   * @param vuln the vulnerability status to set
   */
  public void setVulnerable(boolean vulnerable) {
    this.vulnerable = vulnerable;
  }

  /**
   * Returns the name of the ghost as a String.
   *
   * @return the name of the ghost as a String.
   */
  public String getName() {
    return this.name;
  }

  /**
   * Moves the ghost depending on the Pacman position.
   * 
   * @param pacman the Pacman model to determine the Ghost movement.
   */
  public abstract void move(java.awt.Point target, MapModel map);

  public static Point moveBackward(Point start, Point nextCell, MapModel map) {
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

  public static boolean checkCell(Point cell, ItemModel[][] map) {
    if (map[cell.x][cell.y] instanceof WallModel || (cell.x == 14 && (cell.y == 0 || cell.y == 27))) {
      return false;
    }
    return true;
  }

  public static List<Point> getAvailableCell(Point cell, ItemModel[][] map) {
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
