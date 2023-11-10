package src.main.mvc.controller;

import src.main.mvc.model.item.ItemModel;
import src.main.mvc.utils.BadDimensionsException;

/**
 * The MapFactoryController class is responsible for creating a 2D array of
 * ItemModel objects based on a given schema.
 * The schema is a 2D array of items representing the map.
 */
public class MapFactoryController {
  /**
   * Creates a 2D array of ItemModel objects based on the given schema.
   * The schema is a 2D array of characters representing the map.
   * 'w' represents a wall, 'd' represents a dot, and 'D' represents a big dot.
   * Any other character is considered empty space.
   * 
   * @param schema the 2D array of characters representing the map
   * @return a 2D array of ItemModel objects representing the map
   */
  public ItemModel[][] createMapFromSchema(String[] schema, int rows, int columns) {
    ItemFactoryController factory = new ItemFactoryController();

    ItemModel[][] map = new ItemModel[rows][columns];

    try {
      if (schema.length != rows) {
        throw new BadDimensionsException("Wrong dimensions, check the map schema.");
      }

      for (int i = 0; i < columns; i++) {
        if (schema[i].length() != columns) {
          throw new BadDimensionsException("Wrong dimensions, check the map schema.");
        }
      }

      for (int i = 0; i < schema.length && schema.length == rows; i++) {
        for (int j = 0; j < schema[i].length() && schema[i].length() == columns; j++) {
          switch (schema[i].charAt(j)) {
            case 'w':
              map[i][j] = factory.getWall();
              break;
            case 'd':
              map[i][j] = factory.getDot();
              break;
            case 'D':
              map[i][j] = factory.getBigDot();
              break;
            default:
              map[i][j] = null;
          }
        }
      }
    } catch (BadDimensionsException e) {
      System.out.println(e.getMessage());
    }

    return map;
  }
}
