package src.test.mvc.model.item.fruit;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import src.main.mvc.model.item.fruit.BellModel;

/**
 * This class contains unit tests for the {@link BellModel} class.
 */
public class BellModelTest {
  BellModel bell = new BellModel(10);

  @Test
  public void getSpawnAt() {
    int spawnAt = bell.getSpawnAt();

    assertEquals(10, spawnAt);
  }

  @Test
  public void getScore() {
    int score = bell.getScore();

    assertEquals(3000, score);
  }
}
