package src.test.mvc.model.character.ghost;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.awt.Point;

import org.junit.jupiter.api.Test;

import src.main.mvc.model.character.GhostModel;
import src.main.mvc.model.character.ghost.BlinkyModel;
import src.main.mvc.model.map.Level1;

// TODO: add move() test when implemented

public class BlinkyModelTest {
  Level1 level1 = new Level1();
  BlinkyModel blinky = new BlinkyModel(new Point(10, 10),level1);

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
    String name = blinky.getName();

    assertEquals("Blinky", name);
  }

  @Test
  void checkNullPosition() {
    assertNotNull(blinky.getPosition());
  }

  @Test
  void moveUp() {
    int posY = (int) blinky.getPosition().getY();

    blinky.moveUp();
    blinky.moveUp();

    assertEquals(posY - 2, (int) blinky.getPosition().getY());
  }

  @Test
  void moveDown() {
    int posY = (int) blinky.getPosition().getY();

    blinky.moveDown();
    blinky.moveDown();

    assertEquals(posY + 2, (int) blinky.getPosition().getY());
  }

  @Test
  void moveLeft() {
    int posX = (int) blinky.getPosition().getX();

    blinky.moveLeft();
    blinky.moveLeft();

    assertEquals(posX - 2, (int) blinky.getPosition().getX());
  }

  @Test
  void moveRight() {
    int posX = (int) blinky.getPosition().getX();

    blinky.moveRight();
    blinky.moveRight();

    assertEquals(posX + 2, (int) blinky.getPosition().getX());
  }
}
