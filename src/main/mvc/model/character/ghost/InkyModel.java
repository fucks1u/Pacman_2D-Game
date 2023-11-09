package src.main.mvc.model.character.ghost;

import java.awt.Point;

import src.main.mvc.model.character.GhostModel;
import src.main.mvc.model.character.PacmanModel;

public class InkyModel extends GhostModel {
  public InkyModel(Point position) {
    super("Inky", position);
  }

  @Override
  public void Move(PacmanModel pacman) {
    throw new UnsupportedOperationException("Not implemented");
  }
}
