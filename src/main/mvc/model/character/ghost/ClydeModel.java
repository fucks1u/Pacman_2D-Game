package src.main.mvc.model.character.ghost;

import java.awt.Point;

import src.main.mvc.model.character.GhostModel;
import src.main.mvc.model.character.PacmanModel;

/**
 * This class represents the model of the Ghost Clyde in the game.
 * It extends the GhostModel class and implements the movement logic for Clyde.
 */
public class ClydeModel extends GhostModel {
  public ClydeModel(Point position) {
    super("Clyde", position);
  }

  /**
   * Moves Clyde depending on the Pacman position.
   * If the Pacman is far, Clyde chase him, else he wanders away.
   * 
   * @param pacman the Pacman model to determine the Clyde movement.
   */
  @Override
  public void Move(PacmanModel pacman) {
    throw new UnsupportedOperationException("Not implemented");
  }
}
