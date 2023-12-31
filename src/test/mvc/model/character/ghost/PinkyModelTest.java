package src.test.mvc.model.character.ghost;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.awt.Point;

import org.junit.jupiter.api.Test;

import src.main.mvc.model.character.ghost.PinkyModel;

public class PinkyModelTest {
  PinkyModel pinky = new PinkyModel(new Point(10, 10));

  @Test
  void checkVulnerability() {
    assertFalse(pinky.isVulnerable());
  }

  @Test
  void enableVulnerability() {
    pinky.setVulnerable(true);
    assertTrue(pinky.isVulnerable());
    pinky.setVulnerable(false);
  }

  @Test
  void getName() {
    String name = pinky.getName();

    assertEquals("Pinky", name);
  }

  @Test
  void checkNullPosition() {
    assertNotNull(pinky.getPosition());
  }

  @Test
  void moveUp() {
    int posY = (int) pinky.getPosition().getY();

    pinky.moveUp();
    pinky.moveUp();

    assertEquals(posY - 2, (int) pinky.getPosition().getY());
  }

  @Test
  void moveDown() {
    int posY = (int) pinky.getPosition().getY();

    pinky.moveDown();
    pinky.moveDown();

    assertEquals(posY + 2, (int) pinky.getPosition().getY());
  }

  @Test
  void moveLeft() {
    int posX = (int) pinky.getPosition().getX();

    pinky.moveLeft();
    pinky.moveLeft();

    assertEquals(posX - 2, (int) pinky.getPosition().getX());
  }

  @Test
  void moveRight() {
    int posX = (int) pinky.getPosition().getX();

    pinky.moveRight();
    pinky.moveRight();

    assertEquals(posX + 2, (int) pinky.getPosition().getX());
  }
}