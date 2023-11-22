package src.main.mvc.utils;

import java.util.List;
import java.util.ArrayList;

import src.main.mvc.model.item.ItemModel;
import src.main.mvc.model.item.WallModel;
import src.main.mvc.model.map.MapModel;

/**
 * Astar class provides methods for finding paths using the A* algorithm.
 */
public class Astar {
  /**
   * Represents a point in a two-dimensional space.
   */
  public static class Point {
    public int x;
    public int y;
    public Point previousPoint;

    /**
     * Constructs a new Point object with the specified coordinates and previous
     * point.
     *
     * @param x        the x-coordinate of the point
     * @param y        the y-coordinate of the point
     * @param previous the previous point in the path
     */
    public Point(int x, int y, Point previous) {
      this.x = x;
      this.y = y;
      this.previousPoint = previous;
    }

    /**
     * Returns the location of the point as a java.awt.Point object.
     *
     * @return the location of the point
     */
    public java.awt.Point getLocation() {
      return new java.awt.Point(x, y);
    }

    /**
     * Returns a new Point object with the coordinates offset by the specified
     * amounts.
     *
     * @param x the x-coordinate offset
     * @param y the y-coordinate offset
     * @return a new Point object with the offset coordinates
     */
    public Point offset(int x, int y) {
      return new Point(this.x + x, this.y + y, this);
    }
  }

  /**
   * Checks if a given point is walkable on the map.
   *
   * @param mapModel The map model containing the map data.
   * @param point    The point to be checked for walkability.
   * @return true if the point is walkable, false otherwise.
   */
  public static boolean isWalkable(MapModel mapModel, Point point) {
    ItemModel[][] map = mapModel.getMap();

    if (point.x < 0 || point.x > map.length - 1 || point.y < 0 || point.y > map[0].length - 1
        || map[point.x][point.y] instanceof WallModel) {
      return false;
    } else {
      return true;
    }
  }

  /**
   * Checks if a given point is walkable on the map (count other ghosts as
   * obstacles).
   * 
   * @param mapModel        the map model containing the map data
   * @param point           the point to check for walkability
   * @param ghostsPositions the positions of the ghosts on the map
   * @return true if the point is walkable, false otherwise
   */
  public static boolean isWalkable(MapModel mapModel, Point point, List<java.awt.Point> ghostsPositions) {
    ItemModel[][] map = mapModel.getMap();

    for (java.awt.Point ghostPosition : ghostsPositions) {
      if (point.x == ghostPosition.getX() && point.y == ghostPosition.getY()) {
        return false;
      }
    }

    if (point.x < 0 || point.x > map.length - 1 || point.y < 0 || point.y > map[0].length - 1
        || map[point.x][point.y] instanceof WallModel) {
      return false;
    } else {
      return true;
    }
  }

  /**
   * Finds the adjacent points of a given point on the map.
   * 
   * @param mapModel the map model containing the map data
   * @param point    the point for which adjacent points are to be found
   * @return a list of adjacent points
   */
  public static List<Point> findAdjacent(MapModel mapModel, Point point) {
    List<Point> adjacent = new ArrayList<>();

    Point up = point.offset(0, 1);
    Point down = point.offset(0, -1);
    Point left = point.offset(-1, 0);
    Point right = point.offset(1, 0);

    if (isWalkable(mapModel, up)) {
      adjacent.add(up);
    }

    if (isWalkable(mapModel, down)) {
      adjacent.add(down);
    }

    if (isWalkable(mapModel, left)) {
      adjacent.add(left);
    }

    if (isWalkable(mapModel, right)) {
      adjacent.add(right);
    }
    return adjacent;
  }

  /**
   * Finds the adjacent points to a given point on the map.
   *
   * @param mapModel        the map model containing the map data
   * @param point           the point for which to find adjacent points
   * @param ghostsPositions the positions of the ghosts on the map
   * @return a list of adjacent points
   */
  public static List<Point> findAdjacent(MapModel mapModel, Point point, List<java.awt.Point> ghostsPositions) {
    List<Point> adjacent = new ArrayList<>();

    Point up = point.offset(0, 1);
    Point down = point.offset(0, -1);
    Point left = point.offset(-1, 0);
    Point right = point.offset(1, 0);

    if (isWalkable(mapModel, up, ghostsPositions)) {
      adjacent.add(up);
    }

    if (isWalkable(mapModel, down, ghostsPositions)) {
      adjacent.add(down);
    }

    if (isWalkable(mapModel, left, ghostsPositions)) {
      adjacent.add(left);
    }

    if (isWalkable(mapModel, right, ghostsPositions)) {
      adjacent.add(right);
    }
    return adjacent;
  }

  /**
   * Checks if a given list contains a specific point.
   * 
   * @param list    the list of points to check
   * @param toCheck the point to search for in the list
   * @return true if the list contains the point, false otherwise
   */
  public static boolean listContains(List<Point> list, Point toCheck) {
    for (Point point : list) {
      if (point.x == toCheck.x && point.y == toCheck.y) {
        return true;
      }
    }
    return false;
  }

  /**
   * Finds a path from the start point to the end point using the A* algorithm.
   *
   * @param mapModel the map model representing the environment
   * @param start    the starting point
   * @param end      the ending point
   * @return a list of points representing the path from start to end, or null if
   *         no path is found
   */
  public static List<Point> findPath(MapModel mapModel, Point start, Point end) {
    boolean completed = false;
    List<Point> used = new ArrayList<>();

    used.add(start);
    while (!completed) {
      List<Point> unused = new ArrayList<>();
      for (int i = 0; i < used.size(); i++) {
        Point point = used.get(i);

        for (Point adjacent : findAdjacent(mapModel, point)) {
          if (!listContains(used, adjacent) && !listContains(unused, adjacent)) {
            unused.add(adjacent);
          }
        }

        for (Point newPoint : unused) {
          if (!listContains(used, newPoint)) {
            used.add(newPoint);
          }
          if (end.getLocation().getY() == newPoint.y && end.getLocation().getX() == newPoint.x) {
            completed = true;
            break;
          }
        }

        if (completed) {
          break;
        }

        if (!completed && unused.isEmpty()) {
          return null;
        }
      }
    }
    List<Point> path = new ArrayList<>();
    Point point = used.get(used.size() - 1);

    while (point.previousPoint != null) {
      path.add(0, point);
      point = point.previousPoint;
    }
    return path;
  }

  /**
   * Finds a path from the start point to the end point on the given map,
   * considering the positions of ghosts.
   * 
   * @param mapModel        The map model representing the game map.
   * @param start           The starting point of the path.
   * @param end             The ending point of the path.
   * @param ghostsPositions The positions of the ghosts on the map.
   * @return A list of points representing the path from the start point to the
   *         end point, or null if no path is found.
   */
  public static List<Point> findPathWithGhosts(MapModel mapModel, Point start, Point end,
      List<java.awt.Point> ghostsPositions) {
    boolean completed = false;
    List<Point> used = new ArrayList<>();

    used.add(start);
    while (!completed) {
      List<Point> unused = new ArrayList<>();
      for (int i = 0; i < used.size(); i++) {
        Point point = used.get(i);

        for (Point adjacent : findAdjacent(mapModel, point, ghostsPositions)) {
          if (!listContains(used, adjacent) && !listContains(unused, adjacent)) {
            unused.add(adjacent);
          }
        }

        for (Point newPoint : unused) {
          if (!listContains(used, newPoint)) {
            used.add(newPoint);
          }
          if (end.getLocation().getY() == newPoint.y && end.getLocation().getX() == newPoint.x) {
            completed = true;
            break;
          }
        }

        if (completed) {
          break;
        }

        if (!completed && unused.isEmpty()) {
          return null;
        }
      }
    }
    List<Point> path = new ArrayList<>();
    Point point = used.get(used.size() - 1);

    while (point.previousPoint != null) {
      path.add(0, point);
      point = point.previousPoint;
    }
    return path;
  }
}