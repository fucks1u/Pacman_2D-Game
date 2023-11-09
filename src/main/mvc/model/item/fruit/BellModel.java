package src.main.mvc.model.item.fruit;

import src.main.mvc.model.item.FruitModel;

/**
 * Represents a model for a bell item with a score of 3000.
 * Inherits the FruitModel class.
 */
public class BellModel extends FruitModel {
  public BellModel(int spawnAt) {
    super(3000, spawnAt);
  }
}
