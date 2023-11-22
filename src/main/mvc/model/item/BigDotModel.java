package src.main.mvc.model.item;

/**
 * Represents a big dot item in the game. When Pac-Man eats a big dot, all
 * ghosts become vulnerable for a short period of time.
 */
public class BigDotModel extends ItemModel {
  public BigDotModel() {
    super(50);
  }
}
