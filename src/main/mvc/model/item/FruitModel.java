package src.main.mvc.model.item;

/**
 * This class represents a FruitModel, which is an abstract class that extends
 * ItemModel.
 * It contains a spawnAt field that represents the time at which the fruit
 * should spawn.
 */
public abstract class FruitModel extends ItemModel {
  private int spawnAt;

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
}
