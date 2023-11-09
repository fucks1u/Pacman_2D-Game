package test.mvc.model.item.fruit;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import main.mvc.model.item.fruit.KeyModel;

/**
 * This class contains unit tests for the {@link KeyModel} class.
 */
public class KeyModelTest {
  KeyModel key = new KeyModel(10);

  @Test
  public void getSpawnAt() {
    int spawnAt = key.getSpawnAt();

    assertEquals(10, spawnAt);
  }

  @Test
  public void getScore() {
    int score = key.getScore();

    assertEquals(5000, score);
  }
}
