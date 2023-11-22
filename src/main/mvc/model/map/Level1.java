package src.main.mvc.model.map;

import src.main.mvc.controller.MapFactoryController;
import src.main.mvc.model.item.ItemModel;

import java.awt.*;

/**
 * Level1 class represents the first level of the game map.
 * It extends the MapModel class and initializes the map for Level1 using a
 * schema.
 */
public class Level1 extends MapModel {

  public Level1() {
    super(initMap());
    this.setVoids(MapFactoryController.getVoids());
    this.addTeleporters(new Point(14, 1), new Point(14, 26));
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
        "wdwwwwdwwwwwdwwdwwwwwdwwwwdw",
        "wDddddddddddddddddddddddddDw",
        "wdwwwwdwwdwwwwwwwwdwwdwwwwdw",
        "wdwwwwdwwdwwwwwwwwdwwdwwwwdw",
        "wddddddwwddddwwddddwwddddddw",
        "wwwwwwdwwwww/ww/wwwwwdwwwwww",
        "wwwwwwdwwwww/ww/wwwwwdwwwwww",
        "#####wdww//////////wwdw#####",
        "#####wdww/www//www/wwdw#####",
        "#####wdww/w//////w/wwdw#####",
        "wwwwwwdww/w//////w/wwdwwwwww",
        "#/////d///w//////w///d/////#",
        "wwwwwwdww/w//////w/wwdwwwwww",
        "#####wdww/w//////w/wwdw#####",
        "#####wdww/wwwwwwww/wwdw#####",
        "#####wdww//////////wwdw#####",
        "wwwwwwdww/wwwwwwww/wwdwwwwww",
        "wwwwwwdww/wwwwwwww/wwdwwwwww",
        "wddddddddddddwwddddddddddddw",
        "wdwwwwdwwwwwdwwdwwwwwdwwwwdw",
        "wdwwwwdwwwwwdwwdwwwwwdwwwwdw",
        "wdddwwddddddddddddddddwwdddw",
        "wwwdwwdwwdwwwwwwwwdwwdwwdwww",
        "wwwdwwdwwdwwwwwwwwdwwdwwdwww",
        "wDdddddwwddddwwddddwwdddddDw",
        "wdwwwwwwwwwwdwwdwwwwwwwwwwdw",
        "wdwwwwwwwwwwdwwdwwwwwwwwwwdw",
        "wddddddddddddddddddddddddddw",
        "wwwwwwwwwwwwwwwwwwwwwwwwwwww",
    };
    return factory.createMapFromSchema(schema, 32, 28);
  }
}
