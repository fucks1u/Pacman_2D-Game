package src.main.mvc.model.character.ghost;

import src.main.mvc.model.character.GhostModel;
import src.main.mvc.model.character.PacmanModel;

public class BlinkyModel extends GhostModel {
  public BlinkyModel() {
    super("Blinky");
  }

  @Override
  public void Move(PacmanModel pacman) {
    throw new UnsupportedOperationException("Not implemented");
  }
}
