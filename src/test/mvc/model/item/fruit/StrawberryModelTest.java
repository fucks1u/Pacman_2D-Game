package test.mvc.model.item.fruit;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import main.mvc.model.item.fruit.StrawberryModel;

/**
 * This class contains unit tests for the {@link StrawberryModel} class.
 */
public class StrawberryModelTest {
  StrawberryModel strawberry = new StrawberryModel(10);

  @Test
  public void getSpawnAt() {
    int spawnAt = strawberry.getSpawnAt();

    assertEquals(10, spawnAt);
  }

  @Test
  public void getScore() {
    int score = strawberry.getScore();

    assertEquals(300, score);
  }
}
