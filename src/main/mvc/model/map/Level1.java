package src.main.mvc.model.map;

import src.main.mvc.controller.MapFactoryController;
import src.main.mvc.model.item.ItemModel;

/**
 * Level1 class represents the first level of the game map.
 * It extends the MapModel class and initializes the map for Level1 using a
 * schema.
 */
public class Level1 extends MapModel {

  public Level1() {
    super(initMap());

  }

  /**
   * Initializes the map for Level1 using a schema and returns an ItemModel[][].
   *
   * @return the ItemModel[][] representing the initialized map
   */
  private static ItemModel[][] initMap() {
    MapFactoryController factory = new MapFactoryController();
    String[] schema = {
        "wwwwwwwwwwwwwwwwwwwwwwwwwwww",
        "wddddddddddddwwddddddddddddw",
        "wdwwwwdwwwwwdwwdwwwwwdwwwwdw",
        "wDwwwwdwwwwwdwwdwwwwwdwwwwDw",
        "wddddddddddddddddddddddddddw",
        "wdwwwwdwwdwwwwwwwwdwwdwwwwdw",
        "wdwwwwdwwdwwwwwwwwdwwdwwwwdw",
        "wddddddwwddddwwddddwwddddddw",
        "wwwwwwdwwwww/ww/wwwwwdwwwwww",
        "wwwwwwdwwwww/ww/wwwwwdwwwwww",
        "/////wdww//////////wwdw/////",
        "/////wdww//////////wwdw/////",
        "/////wdww/www//www/wwdw/////",
        "wwwwwwdww/w//////w/wwdwwwwww",
        "/////wd///w//////w///dw/////",
        "wwwwwwdww/w//////w/wwdwwwwww",
        "/////wdww/wwwwwwww/wwdw/////",
        "/////wdww//////////wwdw/////",
        "/////wdww//////////wwdw/////",
        "wwwwwwdww/wwwwwwww/wwdwwwwww",
        "wddddddddddddwwddddddddddddw",
        "wdwwwwdwwwwwdwwdwwwwwdwwwwdw",
        "wdwwwwdwwwwwdwwdwwwwwdwwwwdw",
        "wDddwwddddddddddddddddwwddDw",
        "wwwdwwdwwdwwwwwwwwdwwdwwdwww",
        "wwwdwwdwwdwwwwwwwwdwwdwwdwww",
        "wddddddwwddddwwddddwwddddddw",
        "wdwwwwwwwwwwdwwdwwwwwwwwwwdw",
        "wdwwwwwwwwwwdwwdwwwwwwwwwwdw",
        "wddddddddddddddddddddddddddw",
        "wwwwwwwwwwwwwwwwwwwwwwwwwwww",
    };

    return factory.createMapFromSchema(schema);
  }
}
