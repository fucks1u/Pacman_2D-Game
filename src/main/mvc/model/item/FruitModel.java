package src.main.mvc.model.item;

import java.awt.Point;
import java.time.LocalTime;

/**
 * This class represents a FruitModel, which is an abstract class that extends
 * ItemModel.
 * It contains a spawnAt field that represents the time at which the fruit
 * should spawn.
 */
public abstract class FruitModel extends ItemModel {
  private int spawnAt;
  private static boolean placed;
  private LocalTime expire;
  private Point position;

  public FruitModel(int score, int spawnAt) {
    super(score);
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

  public LocalTime getExpire() {
    return expire;
  }

  public void setExpire(LocalTime expire) {
    this.expire = expire;
  }

  public Point getPosition() {
    return position;
  }

  public void setPosition(Point position) {
    this.position = position;
  }
}
