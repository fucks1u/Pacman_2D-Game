package main.mvc.model.item.fruit;

import main.mvc.model.item.FruitModel;

/**
 * Represents a model for a melon fruit item with a score of 1000.
 * Inherits the FruitModel class.
 */
public class MelonModel extends FruitModel {
  public MelonModel(int spawnAt) {
    super(1000, spawnAt);
  }
}
