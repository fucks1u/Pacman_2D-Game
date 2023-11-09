package main.mvc.model.item.fruit;

import main.mvc.model.item.FruitModel;

/**
 * Represents a model for a cherry fruit item with a score of 100.
 * Inherits the FruitModel class.
 */
public class CherryModel extends FruitModel {
  public CherryModel() {
    super(100, 70);
  }
  
  public CherryModel(int spawnAt) {
    super(100, spawnAt);
  }
}
