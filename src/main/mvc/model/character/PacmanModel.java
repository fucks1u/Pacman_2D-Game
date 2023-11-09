package src.main.mvc.model.character;

import java.awt.Point;

public class PacmanModel extends CharacterModel {
  private int lives;

  public PacmanModel(Point position) {
    super(position);
    this.lives = 0;
  }

  public int getLives() {
    return this.lives;
  }

  public void setLives(int lives) {
    this.lives = lives;
  }
}
