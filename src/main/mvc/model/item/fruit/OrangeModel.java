package src.main.mvc.model.item.fruit;

import src.main.mvc.model.item.FruitModel;

/**
 * Represents a model for a orange fruit item with a score of 500.
 * Inherits the FruitModel class.
 */
public class OrangeModel extends FruitModel {
  public OrangeModel(int spawnAt) {
    super(500, spawnAt);
  }
}
