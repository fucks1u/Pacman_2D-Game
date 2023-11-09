package main.mvc.model.item.fruit;

import main.mvc.model.item.FruitModel;

/**
 * Represents a model for a key item with a score of 5000.
 * Inherits the FruitModel class.
 */
public class KeyModel extends FruitModel {
  public KeyModel(int spawnAt) {
    super(5000, spawnAt);
  }
}
