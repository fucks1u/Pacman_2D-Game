package test.mvc.model.item.fruit;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import main.mvc.model.item.fruit.CherryModel;

/**
 * This class contains unit tests for the {@link CherryModel} class.
 */
public class CherryModelTest {
  CherryModel cherry = new CherryModel(10);

  @Test
  public void getSpawnAt() {
    int spawnAt = cherry.getSpawnAt();

    assertEquals(10, spawnAt);
  }

  @Test
  public void getScore() {
    int score = cherry.getScore();

    assertEquals(100, score);
  }
}
