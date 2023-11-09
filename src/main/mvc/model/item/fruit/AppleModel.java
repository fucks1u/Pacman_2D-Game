package main.mvc.model.item.fruit;

import main.mvc.model.item.FruitModel;

/**
 * Represents a model for a apple fruit item with a score of 700.
 * Inherits the FruitModel class.
 */
public class AppleModel extends FruitModel {
  public AppleModel(int spawnAt) {
    super(700, spawnAt);
  }
}
