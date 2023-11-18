package src.main.mvc.model.item;

import java.awt.Point;

import src.main.mvc.utils.Clock;

/**
 * This class represents a FruitModel, which is an abstract class that extends
 * ItemModel.
 * It contains a spawnAt field that represents the time at which the fruit
 * should spawn.
 */
public abstract class FruitModel extends ItemModel {
  private int spawnAt;
  private static boolean placed;
  private Clock expire;
  private Point position;

  public FruitModel(int score, int spawnAt) {
    super(score);
    this.expire = new Clock();
    this.spawnAt = spawnAt;
  }

  /**
   * @return the spawn time of the fruit
   */
  public int getSpawnAt() {
    return this.spawnAt;
  }

  public static void setPlaced(boolean bool) {
    placed = bool;
  }

  public static boolean isPlaced() {
    return placed;
  }

  public boolean isExpired() {
    if (this.expire.getSec() >= 10) {
      return true;
    } else {
      return false;
    }
  }

  public void setExpire() {
    this.expire.reset();
  }

  public Point getPosition() {
    return position;
  }

  public void setPosition(Point position) {
    this.position = position;
  }
}
