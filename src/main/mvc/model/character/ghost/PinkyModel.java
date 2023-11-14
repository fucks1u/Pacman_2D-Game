package src.main.mvc.model.character.ghost;

import java.awt.Point;

import src.main.mvc.model.character.GhostModel;
import src.main.mvc.model.character.PacmanModel;
import src.main.mvc.model.item.ItemModel;
import src.main.mvc.model.map.MapModel;

/**
 * This class represents the model of the Ghost Pinky in the game.
 * It extends the GhostModel class and implements the movement logic for Pinky.
 */
public class PinkyModel extends GhostModel {
  private MapModel map;
  public PinkyModel(Point position, MapModel map) {
    super("Pinky", position,map);
    this.map = map;
  }

    /**
   * Moves Pinky depending on the Pacman position.
   * Pinky try to hambush Pacman by moving parallel to him.
   * 
   * @param pacman the Pacman model to determine the Pinky movement.
   */
  @Override
  public void move(PacmanModel pacman) {
    throw new UnsupportedOperationException("Not implemented");
  }
}
