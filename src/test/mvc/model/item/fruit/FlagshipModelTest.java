package test.mvc.model.item.fruit;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import main.mvc.model.item.fruit.FlagshipModel;

/**
 * This class contains unit tests for the {@link FlagshipModel} class.
 */
public class FlagshipModelTest {
  FlagshipModel flagship = new FlagshipModel(10);

  @Test
  public void getSpawnAt() {
    int spawnAt = flagship.getSpawnAt();

    assertEquals(10, spawnAt);
  }

  @Test
  public void getScore() {
    int score = flagship.getScore();

    assertEquals(2000, score);
  }
}
