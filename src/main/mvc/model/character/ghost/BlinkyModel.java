package src.main.mvc.model.character.ghost;

import java.awt.Point;

import src.main.mvc.model.character.GhostModel;
import src.main.mvc.model.character.PacmanModel;

/**
 * This class represents the model of the Ghost Blinky in the game.
 * It extends the GhostModel class and implements the movement logic for Blinky.
 */
public class BlinkyModel extends GhostModel {
  public BlinkyModel(Point position) {
    super("Blinky", position);
  }

  /**
   * Moves Blinky to go towards the Pacman position.
   * 
   * @param pacman the Pacman model to go towards.
   */
  @Override
  public void Move(PacmanModel pacman) {
    throw new UnsupportedOperationException("Not implemented");
  }
}
