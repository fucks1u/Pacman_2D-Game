package src.main.mvc.model.item.fruit;

import src.main.mvc.model.item.FruitModel;

/**
 * Represents a model for a flagship item with a score of 2000.
 * Inherits the FruitModel class.
 */
public class FlagshipModel extends FruitModel {
  public FlagshipModel(int spawnAt) {
    super(2000, spawnAt);
  }
}
