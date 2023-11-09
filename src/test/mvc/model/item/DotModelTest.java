package src.test.mvc.model.item;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import src.main.mvc.model.item.DotModel;

/**
 * This class contains unit tests for the {@link DotModel} class.
 */
public class DotModelTest {
  DotModel dot = new DotModel();

  @Test
  public void getScore() {
    int score = dot.getScore();

    assertEquals(10, score);
  }
}
