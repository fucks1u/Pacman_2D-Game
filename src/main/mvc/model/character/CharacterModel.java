package main.mvc.model.character;

import java.awt.Point;

public abstract class CharacterModel {
  private Point position;

  public CharacterModel(Point position) {
    this.position = position;
  }


  public Point getPosition() {
    return this.position;
  }

  public void moveUp() {
    this.position.setLocation(this.position.getX(), this.position.getY() + 1);
  }

  public void moveDown() {
    this.position.setLocation(this.position.getX(), this.position.getY() - 1);
  }

  public void moveLeft() {
    this.position.setLocation(this.position.getX() - 1, this.position.getY());
  }

  public void moveRight() {
    this.position.setLocation(this.position.getX() + 1, this.position.getY());
  }
}