package src.main.mvc.model.character.ghost;

import java.awt.Point;

import src.main.mvc.model.character.GhostModel;
import src.main.mvc.model.character.PacmanModel;
import src.main.mvc.model.item.ItemModel;
import src.main.mvc.model.map.MapModel;

/**
 * This class represents the model of the Ghost Clyde in the game.
 * It extends the GhostModel class and implements the movement logic for Clyde.
 */
public class ClydeModel extends GhostModel {
  private MapModel map;
  public ClydeModel(Point position, MapModel map) {
    super("Clyde", position,map);
    this.map = map;
  }

  /**
   * Moves Clyde depending on the Pacman position.
   * If the Pacman is far, Clyde chase him, else he wanders away.
   * 
   * @param pacman the Pacman model to determine the Clyde movement.
   */
  @Override
  public void move(PacmanModel pacman) {
    throw new UnsupportedOperationException("Not implemented");
  }
}
