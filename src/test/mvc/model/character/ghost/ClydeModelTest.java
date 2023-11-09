package src.test.mvc.model.character.ghost;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.awt.Point;

import org.junit.jupiter.api.Test;

import src.main.mvc.model.character.GhostModel;
import src.main.mvc.model.character.ghost.ClydeModel;

// TODO: add move() test when implemented

public class ClydeModelTest {
  ClydeModel clyde = new ClydeModel(new Point(10, 10));

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
    String name = clyde.getName();

    assertEquals("Clyde", name);
  }

  @Test
  void checkNullPosition() {
    assertNotNull(clyde.getPosition());
  }

  @Test
  void moveUp() {
    int posY = (int) clyde.getPosition().getY();

    clyde.moveUp();
    clyde.moveUp();

    assertEquals(posY - 2, (int) clyde.getPosition().getY());
  }

  @Test
  void moveDown() {
    int posY = (int) clyde.getPosition().getY();

    clyde.moveDown();
    clyde.moveDown();

    assertEquals(posY + 2, (int) clyde.getPosition().getY());
  }

  @Test
  void moveLeft() {
    int posX = (int) clyde.getPosition().getX();

    clyde.moveLeft();
    clyde.moveLeft();

    assertEquals(posX - 2, (int) clyde.getPosition().getX());
  }

  @Test
  void moveRight() {
    int posX = (int) clyde.getPosition().getX();

    clyde.moveRight();
    clyde.moveRight();

    assertEquals(posX + 2, (int) clyde.getPosition().getX());
  }
}