package src.main.mvc.model.item;

import java.util.concurrent.TimeUnit;

import src.main.mvc.model.character.GhostModel;

/**
 * Represents a big dot item in the game. When Pac-Man eats a big dot, all
 * ghosts become vulnerable for a short period of time.
 */
public class BigDotModel extends ItemModel {
  public BigDotModel() {
    super(50);
  }

  /**
   * Sets the vulnerability of the ghost model to true, waits for 10 seconds, and
   * then sets it back to false.
   */
  public void setVulnerability() {
    GhostModel.setVulnerable(true);
    try {
      TimeUnit.SECONDS.sleep(10);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    GhostModel.setVulnerable(false);
  }
}
