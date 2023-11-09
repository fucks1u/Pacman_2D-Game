package src.main.mvc.model.item.fruit;

import src.main.mvc.model.item.FruitModel;

/**
 * Represents a model for a strawberry fruit item with a score of 300.
 * Inherits the FruitModel class.
 */
public class StrawberryModel extends FruitModel {
  public StrawberryModel() {
    super(300, 170);
  }

  public StrawberryModel(int spawnAt) {
    super(300, spawnAt);
  }
}
