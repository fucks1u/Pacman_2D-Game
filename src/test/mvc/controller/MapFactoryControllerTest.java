package src.test.mvc.controller;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import src.main.mvc.controller.MapFactoryController;
import src.main.mvc.model.item.ItemModel;

public class MapFactoryControllerTest {
  MapFactoryController factory = new MapFactoryController();

  @Test
  public void createSchema() {
    String[] schema = {
        "wwwww",
        "w/d/w",
        "w/D/w",
        "w/d/w",
        "wwwww",
    };
    ItemModel[][] map = factory.createMapFromSchema(schema, 5, 5);
    int rows = map.length;
    int cols = map[0].length;

    assertEquals(5, rows);
    assertEquals(5, cols);
  }

  @Test
  public void checkBadDimensions() {
    {
      String[] schema = {
          "wwwww",
          "w/d/w",
          "w/D/wwwwwwwwwwwww",
          "w/d/w",
          "wwwww",
          "wwwww",
      };
      ItemModel[][] map = factory.createMapFromSchema(schema, 5, 5);
      int rows = map.length;
      int cols = map[0].length;

      for (int i = 0; i < rows; i++) {
        for (int j = 0; j < cols; j++) {
          assertNull(map[i][j]);
        }
      }
    }
  }
}
