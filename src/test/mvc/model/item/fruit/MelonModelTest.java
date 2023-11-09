package test.mvc.model.item.fruit;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import main.mvc.model.item.fruit.MelonModel;

/**
 * This class contains unit tests for the {@link MelonModel} class.
 */
public class MelonModelTest {
  MelonModel melon = new MelonModel(10);

  @Test
  public void getSpawnAt() {
    int spawnAt = melon.getSpawnAt();

    assertEquals(10, spawnAt);
  }

  @Test
  public void getScore() {
    int score = melon.getScore();

    assertEquals(1000, score);
  }
}
