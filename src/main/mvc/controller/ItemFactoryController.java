package src.main.mvc.controller;

import src.main.mvc.model.item.BigDotModel;
import src.main.mvc.model.item.DotModel;
import src.main.mvc.model.item.FruitModel;
import src.main.mvc.model.item.WallModel;
import src.main.mvc.model.item.fruit.AppleModel;
import src.main.mvc.model.item.fruit.BellModel;
import src.main.mvc.model.item.fruit.CherryModel;
import src.main.mvc.model.item.fruit.FlagshipModel;
import src.main.mvc.model.item.fruit.KeyModel;
import src.main.mvc.model.item.fruit.MelonModel;
import src.main.mvc.model.item.fruit.OrangeModel;
import src.main.mvc.model.item.fruit.StrawberryModel;
import src.main.mvc.utils.NoSuchFruitException;

/**
 * The ItemFactoryController class is responsible for creating different types
 * of game items, such as fruits, dots, and walls.
 */
public class ItemFactoryController {
  /**
   * Returns a FruitModel object based on the given fruit type and spawn location.
   * 
   * @param fruit   the type of fruit to create
   * @param spawnAt the location where the fruit should spawn
   * @return a FruitModel object representing the specified fruit type
   * @throws NoSuchFruitException if the specified fruit type is invalid
   */
  public FruitModel getFruit(String fruit, int spawnAt) throws NoSuchFruitException {
    switch (fruit) {
      case "apple":
        return new AppleModel(spawnAt);
      case "bell":
        return new BellModel(spawnAt);
      case "cherry":
        return new CherryModel(spawnAt);
      case "flagship":
        return new FlagshipModel(spawnAt);
      case "key":
        return new KeyModel(spawnAt);
      case "melon":
        return new MelonModel(spawnAt);
      case "orange":
        return new OrangeModel(spawnAt);
      case "strawberry":
        return new StrawberryModel(spawnAt);
      default:
        throw new NoSuchFruitException("No such fruit: " + fruit + ".");
    }
  }

  /**
   * Create a new DotModel.
   *
   * @return a Dot model.
   */
  public DotModel getDot() {
    return new DotModel();
  }

  /**
   * Create a new BigDotModel.
   *
   * @return a BigDot model.
   */
  public BigDotModel getBigDot() {
    return new BigDotModel();
  }

  /**
   * Create a new WallModel.
   *
   * @return a Wall
   */
  public WallModel getWall() {
    return new WallModel();
  }
}
