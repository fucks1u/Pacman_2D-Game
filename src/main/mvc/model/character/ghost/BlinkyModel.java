package src.main.mvc.model.character.ghost;

import java.awt.Point;

import src.main.mvc.model.character.GhostModel;
import src.main.mvc.model.character.PacmanModel;
import src.main.mvc.model.item.ItemModel;
import src.main.mvc.model.map.MapModel;

/**
 * This class represents the model of the Ghost Blinky in the game.
 * It extends the GhostModel class and implements the movement logic for Blinky.
 */
public class BlinkyModel extends GhostModel {
  private MapModel map;
  public BlinkyModel(Point position, MapModel map) {
    super("Blinky", position, map);
    this.map = map;
  }

  /**
   * Moves Blinky to go towards the Pacman position.
   * 
   * @param pacman the Pacman model to go towards.
   */
  @Override
  public void move(PacmanModel pacman) {
    throw new UnsupportedOperationException("Not implemented");
  }
}
