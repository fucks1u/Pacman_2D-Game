package src.test.mvc.model.character.ghost;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.awt.Point;

import org.junit.jupiter.api.Test;

import src.main.mvc.model.character.GhostModel;
import src.main.mvc.model.character.ghost.PinkyModel;
import src.main.mvc.model.map.Level1;

// TODO: add move() test when implemented

public class PinkyModelTest {
  Level1 level1 = new Level1();
  PinkyModel pinky = new PinkyModel(new Point(10, 10), level1);

  @Test
  void checkVulnerability() {
    assertFalse(GhostModel.isVulnerable());
  }

  @Test
  void enableVulnerability() {
    GhostModel.setVulnerable(true);
    assertTrue(GhostModel.isVulnerable());
    GhostModel.setVulnerable(false);
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