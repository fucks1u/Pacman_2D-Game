package src.main.mvc.model.character;

import java.awt.Point;

public abstract class GhostModel extends CharacterModel {
  public static boolean vulnerable = false;
  private String name;

  public GhostModel(String name, Point position) {
    super(position);
    this.name = name;
  }

  public static boolean isVulnerable() {
    return vulnerable;
  }

  public static void setVulnerable(boolean vuln) {
    vulnerable = vuln;
  }

  public String getName() {
    return this.name;
  }

  public void Move(PacmanModel pacman) {
    throw new UnsupportedOperationException("Not implemented");
  }
}
