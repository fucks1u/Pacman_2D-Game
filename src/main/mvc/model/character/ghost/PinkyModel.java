package src.main.mvc.model.character.ghost;

import src.main.mvc.model.character.GhostModel;
import src.main.mvc.model.character.PacmanModel;

public class PinkyModel extends GhostModel {
  public PinkyModel() {
    super("Pinky");
  }

  @Override
  public void Move(PacmanModel pacman) {
    throw new UnsupportedOperationException("Not implemented");
  }
}
