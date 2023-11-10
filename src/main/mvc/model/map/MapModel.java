package src.main.mvc.model.map;

import java.awt.Point;

import src.main.mvc.model.item.ItemModel;
import src.main.mvc.model.item.WallModel;

/**
 * The MapModel class represents a 2D map of ItemModel objects.
 * It provides methods to retrieve items at specific positions and to check if a
 * position is accessible.
 */
public abstract class MapModel {
  private ItemModel[][] map;

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
    int posX = (int) position.getX();
    int posY = (int) position.getY();

    return this.map[posX][posY];
  }

  /**
   * Checks if a given position is accessible on the map.
   * 
   * @param position the position to check
   * @return true if the position is accessible, false otherwise
   */
  public boolean isAccessible(Point position) {
    int posX = (int) position.getX();
    int posY = (int) position.getY();

    if (this.map[posX][posY] instanceof WallModel) {
      return false;
    } else {
      return true;
    }
  }
}
