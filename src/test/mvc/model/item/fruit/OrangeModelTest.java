package src.test.mvc.model.item.fruit;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import src.main.mvc.model.item.fruit.OrangeModel;

/**
 * This class contains unit tests for the {@link OrangeModel} class.
 */
public class OrangeModelTest {
  OrangeModel orange = new OrangeModel(10);

  @Test
  public void getSpawnAt() {
    int spawnAt = orange.getSpawnAt();

    assertEquals(10, spawnAt);
  }

  @Test
  public void getScore() {
    int score = orange.getScore();

    assertEquals(500, score);
  }
}
