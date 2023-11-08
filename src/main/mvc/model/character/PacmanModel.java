package src.main.mvc.model.character;

public class PacmanModel extends CharacterModel {
  private int lives;

  public PacmanModel() {
    this.lives = 0;
  }

  public int getLives() {
    return this.lives;
  }

  public void setLives(int lives) {
    this.lives = lives;
  }
}
