package src.main.mvc.model.character.ghost;

import java.awt.Point;

import src.main.mvc.model.character.GhostModel;
import src.main.mvc.model.character.PacmanModel;

/**
 * This class represents the model of the Ghost Pinky in the game.
 * It extends the GhostModel class and implements the movement logic for Pinky.
 */
public class PinkyModel extends GhostModel {
  public PinkyModel(Point position) {
    super("Pinky", position);
  }

    /**
   * Moves Pinky depending on the Pacman position.
   * Pinky try to hambush Pacman by moving parallel to him.
   * 
   * @param pacman the Pacman model to determine the Pinky movement.
   */
  @Override
  public void Move(PacmanModel pacman) {
    throw new UnsupportedOperationException("Not implemented");
  }
}
