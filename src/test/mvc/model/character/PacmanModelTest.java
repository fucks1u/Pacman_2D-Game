package src.test.mvc.model.character;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.awt.Point;

import org.junit.jupiter.api.Test;

import src.main.mvc.model.character.PacmanModel;

public class PacmanModelTest {
  PacmanModel pacman = new PacmanModel(new Point(10, 10));

  @Test
  void lives() {
    int lives = pacman.getLives();
    assertEquals(1, lives);
  }

  @Test
  void checkNullPosition() {
    assertNotNull(pacman.getPosition());
  }

  @Test
  void moveUp() {
    int posY = (int) pacman.getPosition().getY();

    pacman.moveUp();
    pacman.moveUp();

    assertEquals(posY - 2, (int) pacman.getPosition().getY());
  }

  @Test
  void moveDown() {
    int posY = (int) pacman.getPosition().getY();

    pacman.moveDown();
    pacman.moveDown();

    assertEquals(posY + 2, (int) pacman.getPosition().getY());
  }

  @Test
  void moveLeft() {
    int posX = (int) pacman.getPosition().getX();

    pacman.moveLeft();
    pacman.moveLeft();

    assertEquals(posX - 2, (int) pacman.getPosition().getX());
  }

  @Test
  void moveRight() {
    int posX = (int) pacman.getPosition().getX();

    pacman.moveRight();
    pacman.moveRight();

    assertEquals(posX + 2, (int) pacman.getPosition().getX());
  }
}
