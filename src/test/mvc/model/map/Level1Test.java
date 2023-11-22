package src.test.mvc.model.map;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import src.main.mvc.model.item.ItemModel;
import src.main.mvc.model.map.Level1;

/**
 * This class contains unit tests for the {@link Level1Test} class.
 */
public class Level1Test {
  Level1 level = new Level1();

  @Test
  public void getMap() {
    assertEquals(ItemModel[][].class.getName(), level.getMap().getClass().getName());
  }

  @Test
  public void checkMapSize() {
    ItemModel[][] map = level.getMap();
    int rows = map.length;
    int cols = map[0].length;

    assertEquals(31, rows);
    assertEquals(28, cols);
  }
}
