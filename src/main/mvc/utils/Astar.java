package src.main.mvc.utils;

import java.util.List;
import java.util.ArrayList;

import src.main.mvc.model.item.ItemModel;
import src.main.mvc.model.item.WallModel;
import src.main.mvc.model.map.MapModel;

public class Astar {
  public static class Point {
    public int x;
    public int y;
    public Point previousPoint;

    public Point(int x, int y, Point previous) {
      this.x = x;
      this.y = y;
      this.previousPoint = previous;
    }

    public java.awt.Point getLocation() {
      return new java.awt.Point(x, y);
    }

    public Point offset(int x, int y) {
      return new Point(this.x + x, this.y + y, this);
    }
  }

  public static boolean isWalkable(MapModel mapModel, Point point) {
    ItemModel[][] map = mapModel.getMap();

    if (point.x < 0 || point.x > map.length - 1 || point.y < 0 || point.y > map[0].length - 1
        || map[point.x][point.y] instanceof WallModel) {
      return false;
    } else {
      return true;
    }
  }

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

  public static boolean listContains(List<Point> list, Point toCheck) {
    for (Point point : list) {
      if (point.x == toCheck.x && point.y == toCheck.y) {
        return true;
      }
    }
    return false;
  }

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
}