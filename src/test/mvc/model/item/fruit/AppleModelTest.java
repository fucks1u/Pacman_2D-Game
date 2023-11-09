package test.mvc.model.item.fruit;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import main.mvc.model.item.fruit.AppleModel;

/**
 * This class contains unit tests for the {@link AppleModel} class.
 */
public class AppleModelTest {
  AppleModel apple = new AppleModel(10);

  @Test
  public void getSpawnAt() {
    int spawnAt = apple.getSpawnAt();

    assertEquals(10, spawnAt);
  }

  @Test
  public void getScore() {
    int score = apple.getScore();

    assertEquals(700, score);
  }
}
