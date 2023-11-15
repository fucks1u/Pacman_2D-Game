package src.main.mvc.model.character;

import java.awt.Point;

import src.main.mvc.model.map.MapModel;

/**
 * The GhostModel class represents the abstract model of a ghost character in the game.
 * It extends the CharacterModel class and provides methods to get and set the vulnerability status of the ghost,
 * get the name of the ghost, and move the ghost depending on the Pacman position.
 */
public abstract class GhostModel extends CharacterModel {
  public static boolean vulnerable = false;
  private String name;

  public GhostModel(String name, Point position) {
    super(position);
    this.name = name;
  }

  /**
   * Returns whether the ghost is currently vulnerable or not.
   *
   * @return true if the ghost is vulnerable, false otherwise.
   */
  public static boolean isVulnerable() {
    return vulnerable;
  }

  /**
   * Sets the vulnerability status of the ghost.
   * 
   * @param vuln the vulnerability status to set
   */
  public static void setVulnerable(boolean vuln) {
    vulnerable = vuln;
  }

  /**
   * Returns the name of the ghost as a String.
   *
   * @return the name of the ghost as a String.
   */
  public String getName() {
    return this.name;
  }

  /**
   * Moves the ghost depending on the Pacman position.
   * 
   * @param pacman the Pacman model to determine the Ghost movement.
   */
  public abstract void move(java.awt.Point target, MapModel map);
}
