package test.mvc.model.character.ghost;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.awt.Point;

import org.junit.jupiter.api.Test;

import main.mvc.model.character.GhostModel;
import main.mvc.model.character.ghost.InkyModel;

// TODO: add move() test when implemented

public class InkyModelTest {
  InkyModel inky = new InkyModel(new Point(10, 10));

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
    String name = inky.getName();

    assertEquals("Inky", name);
  }

  @Test
  void checkNullPosition() {
    assertNotNull(inky.getPosition());
  }

  @Test
  void moveUp() {
    int posY = (int) inky.getPosition().getY();

    inky.moveUp();
    inky.moveUp();

    assertEquals(posY - 2, (int) inky.getPosition().getY());
  }

  @Test
  void moveDown() {
    int posY = (int) inky.getPosition().getY();

    inky.moveDown();
    inky.moveDown();

    assertEquals(posY + 2, (int) inky.getPosition().getY());
  }

  @Test
  void moveLeft() {
    int posX = (int) inky.getPosition().getX();

    inky.moveLeft();
    inky.moveLeft();

    assertEquals(posX - 2, (int) inky.getPosition().getX());
  }

  @Test
  void moveRight() {
    int posX = (int) inky.getPosition().getX();

    inky.moveRight();
    inky.moveRight();

    assertEquals(posX + 2, (int) inky.getPosition().getX());
  }
}