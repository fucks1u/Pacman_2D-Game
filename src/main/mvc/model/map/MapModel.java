package src.main.mvc.model.map;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import src.main.mvc.model.item.BigDotModel;
import src.main.mvc.model.item.DotModel;
import src.main.mvc.model.item.ItemModel;
import src.main.mvc.model.item.WallModel;

/**
 * The MapModel class represents a 2D map of ItemModel objects.
 * It provides methods to retrieve items at specific positions and to check if a
 * position is accessible.
 */
public abstract class MapModel {
  private ItemModel[][] map;
  private List<Point> voids = new ArrayList<>();
  private HashMap<Point, Point> teleporters = new HashMap<>();

  public MapModel(ItemModel[][] map) {
    this.map = map;
  }

  /**
   * @return the 2D array of ItemModel objects representing the map.
   */
  public ItemModel[][] getMap() {
    return map;
  }

  /**
   * Returns the item at the specified position.
   *
   * @param position the position of the item to retrieve
   * @return the item at the specified position
   */
  public ItemModel getCell(Point position) {
    int x = (int) position.getX();
    int y = (int) position.getY();

    return this.map[x][y];
  }

  /**
   * Sets the item in the specified position of the map.
   * 
   * @param position the position of the cell to be set.
   * @param item     the item to be set in the cell.
   */
  public void setCell(Point position, ItemModel item) {
    int x = (int) position.getX();
    int y = (int) position.getY();

    this.map[x][y] = item;
  }

  /**
   * Sets the cell at the given position to null.
   * 
   * @param position the position of the cell to set
   */
  public void setCell(Point position) {
    int x = (int) position.getX();
    int y = (int) position.getY();

    this.map[x][y] = null;
  }

  /**
   * Returns a list of points representing the spawn locations on the map.
   *
   * @return a list of points representing the spawn locations on the map
   */
  public List<Point> getSpawn() {
    List<Point> spawn = new ArrayList<>();
    for (int i = 9; i < 19; i++) {
      for (int j = 9; j < 19; j++) {
        spawn.add(new Point(i, j));
      }
    }
    return spawn;
  }

  public List<Point> getGhostSpawn() {
    List<Point> spawn = new ArrayList<>();
    for (int i = 11; i < 17; i++) {
      for (int j = 11; j < 17; j++) {
        spawn.add(new Point(i, j));
      }
    }
    return spawn;
  }

  /**
   * Checks if a given position is accessible on the map.
   * 
   * @param position the position to check
   * @return true if the position is accessible, false otherwise
   */
  public boolean isAccessible(Point position) {
    int x = (int) position.getX();
    int y = (int) position.getY();

    if (this.map[x][y] instanceof WallModel) {
      return false;
    } else {
      return true;
    }
  }

  /**
   * Returns the number of dots and big dots in the map.
   *
   * @return the number of dots and big dots in the map
   */
  public int getDot() {
    int k = 0;
    for (int i = 0; i < this.map.length; i++) {
      for (int j = 0; j < this.map[0].length; j++) {
        ItemModel item = getCell(new Point(i, j));
        if (item instanceof DotModel || item instanceof BigDotModel) {
          k++;
        }
      }
    }
    return k;
  }

    /**
     * Returns a list of points representing the voids on the map.
     *
     * @return a list of points representing the voids on the map
     */
    public List<Point> getVoids() {
      return voids;
    }

    /**
     * Sets the voids on the map.
     *
     * @param voids the voids to set
     */
    public void setVoids(List<Point> voids) {
      this.voids = voids;
    }

    /**
     * Adds a void to the list of voids on the map.
     *
     * @param voids the voids to set
     */
    public void addTeleporters(Point p1, Point p2) {
      teleporters.put(p1, p2);
      teleporters.put(p2, p1);
    }

    public boolean isTeleporter(Point p) {
      return teleporters.containsKey(p);
    }
    public Point getTeleporter(Point p) {
      return teleporters.get(p);
    }
}
