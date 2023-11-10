package src.main.mvc.model.character.ghost;

import java.awt.Point;

import src.main.mvc.model.character.GhostModel;
import src.main.mvc.model.character.PacmanModel;

/**
 * This class represents the model of the Ghost Inky in the game.
 * It extends the GhostModel class and implements the movement logic for Inky.
 */
public class InkyModel extends GhostModel {
  public InkyModel(Point position) {
    super("Inky", position);
  }

  /**
   * Moves the InkyModel based on the position of the PacmanModel.
   * Inky try to get Pacman between him and Blinky. 
   * 
   * @param pacman the PacmanModel used to determine Inky movement.
   */
  @Override
  public void Move(PacmanModel pacman) {
    throw new UnsupportedOperationException("Not implemented");
  }
}
