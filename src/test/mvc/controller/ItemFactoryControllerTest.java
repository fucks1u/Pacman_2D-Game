package src.test.mvc.controller;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import src.main.mvc.controller.ItemFactoryController;
import src.main.mvc.model.item.BigDotModel;
import src.main.mvc.model.item.DotModel;
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
 * This class contains unit tests for the {@link ItemFactoryController} class.
 */
public class ItemFactoryControllerTest {
  ItemFactoryController factory = new ItemFactoryController();

  @Test
  public void getFruit() {
    try {
      assertEquals(AppleModel.class.getName(), factory.getFruit("apple", 10).getClass().getName());
      assertEquals(BellModel.class.getName(), factory.getFruit("bell", 10).getClass().getName());
      assertEquals(CherryModel.class.getName(), factory.getFruit("cherry", 10).getClass().getName());
      assertEquals(FlagshipModel.class.getName(), factory.getFruit("flagship", 10).getClass().getName());
      assertEquals(KeyModel.class.getName(), factory.getFruit("key", 10).getClass().getName());
      assertEquals(MelonModel.class.getName(), factory.getFruit("melon", 10).getClass().getName());
      assertEquals(OrangeModel.class.getName(), factory.getFruit("orange", 10).getClass().getName());
      assertEquals(StrawberryModel.class.getName(), factory.getFruit("strawberry", 10).getClass().getName());
      factory.getFruit("test", 10);
    } catch (NoSuchFruitException e) {
      assertEquals(e.getMessage(), "No such fruit: test.");
    }
  }

  @Test
  public void getDot() {
    assertEquals(DotModel.class.getName(), factory.getDot().getClass().getName());
  }

  @Test
  public void getBigDot() {
    assertEquals(BigDotModel.class.getName(), factory.getBigDot().getClass().getName());
  }

  @Test
  public void getWall() {
    assertEquals(WallModel.class.getName(), factory.getWall().getClass().getName());
  }
}
