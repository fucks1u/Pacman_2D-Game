package src.main.mvc.model.item;

/**
 * The Item class represents a generic item in the game.
 * It contains a score attribute that can be accessed and modified.
 */
public abstract class ItemModel {
  private int score;

  public ItemModel(int score) {
    this.score = score;
  }

  /**
   * @return the score of the item.
   */
  public int getScore() {
    return score;
  }
}
