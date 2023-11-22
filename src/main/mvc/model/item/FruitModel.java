package src.main.mvc.model.item;

import java.awt.Point;

/**
 * This class represents a FruitModel, which is an abstract class that extends
 * ItemModel.
 * It contains a spawnAt field that represents the time at which the fruit
 * should spawn.
 */
public abstract class FruitModel extends ItemModel {
  private int spawnAt;
  private static boolean placed;
  public boolean active;
  private Point position;

  public FruitModel(int score, int spawnAt) {
    super(score);
    this.spawnAt = spawnAt;
    this.active = false;
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

  public boolean isActive() {
    return this.active;
  }

  public void setActive(boolean active) {
    this.active = active;
  }

  public Point getPosition() {
    return position;
  }

  public void setPosition(Point position) {
    this.position = position;
  }
}
