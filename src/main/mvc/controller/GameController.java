package src.main.mvc.controller;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import src.main.mvc.model.character.GhostModel;
import src.main.mvc.model.character.PacmanModel;
import src.main.mvc.model.character.ghost.BlinkyModel;
import src.main.mvc.model.character.ghost.ClydeModel;
import src.main.mvc.model.character.ghost.InkyModel;
import src.main.mvc.model.character.ghost.PinkyModel;
import src.main.mvc.model.item.FruitModel;
import src.main.mvc.model.item.ItemModel;
import src.main.mvc.model.item.WallModel;
import src.main.mvc.model.item.fruit.BellModel;
import src.main.mvc.model.item.fruit.CherryModel;
import src.main.mvc.model.item.fruit.OrangeModel;
import src.main.mvc.model.map.MapModel;
import src.main.mvc.utils.Clock;

public class GameController {
  private int score = 0;
  private MapModel map;
  private PacmanModel pacman;
  private List<GhostModel> ghosts;
  private List<FruitModel> fruits;

  public GameController(MapModel map) {
    this.map = map;
    this.pacman = new PacmanModel(new Point(18, 13));
    this.ghosts = Arrays.asList(
        new BlinkyModel(new Point(13, 12)),
        new ClydeModel(new Point(13, 13)),
        new InkyModel(new Point(13, 14)),
        new PinkyModel(new Point(13, 15)));
    this.fruits = Arrays.asList(
        new CherryModel(70),
        new BellModel(140),
        new OrangeModel(210));
  }

  /**
   * This method runs the game loop until either the player runs out of lives or
   * all the dots on the map are eaten.
   * It updates the direction of the Pacman depending on the user inputs and moves
   * the Pacman accordingly.
   * It also checks for collisions with other game objects and updates the score
   * accordingly.
   */
  public void game() {
    Clock gameTimer = new Clock();
    Clock fpsTimer = new Clock();
    Clock moveTimer = new Clock();
    int fps = 0;
    while (pacman.getLives() > 0 && map.getDot() > 0) {
      if (fpsTimer.getSec() >= 1) {
        System.out.printf("[GCtrl] FPS: %d, Time: %d%n", fps, gameTimer.getSec());
        fpsTimer.reset();
        fps = 0;
      } else {
        fps++;
      }

      if (moveTimer.getMs() >= 90) {
        moveTimer.reset();

        // TODO: change direction depending on user input
        this.pacman.setDirection(PacmanModel.directions.UP);

        if (checkCell()) {
          pacman.move();
          System.out.printf("[GCtrl] Pacman: [x=%d, y=%d]%n", (int) this.pacman.getPosition().getX(),
              (int) this.pacman.getPosition().getY());
          if (map.getCell(pacman.getPosition()) != null) {
            this.score += map.getCell(pacman.getPosition()).getScore();
            this.map.setCell(pacman.getPosition());
          }
        }
        this.ghosts.get(0).move(this.pacman.getPosition(), map);
        System.out.printf("[GCtrl] Blinky: [x=%d, y=%d]%n", (int) this.ghosts.get(0).getPosition().getX(),
            (int) this.ghosts.get(0).getPosition().getY());
      }

      if (FruitModel.isPlaced()) {
        FruitModel currentFruit = null;
        for (FruitModel fruit : this.fruits) {
          if (!fruit.isExpired()) {
            currentFruit = fruit;
          }
        }

        if (!currentFruit.isExpired()) {
          map.setCell(currentFruit.getPosition());
          FruitModel.setPlaced(false);
        }
      }

      spawnItem(fruits);
      checkCollision();

      try {
        TimeUnit.MILLISECONDS.sleep((long) 16.666666667);
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }

  /**
   * Checks if the cell in front of Pacman is a valid move.
   * 
   * @return true if the cell is not a wall, false otherwise.
   */
  public boolean checkCell() {
    if (pacman.getDirection() == null) {
      return false;
    } else {
      Point cell = pacman.getPosition().getLocation();
      switch ((PacmanModel.directions) pacman.getDirection()) {
        case UP:
          cell.setLocation(cell.getX(), cell.getY() - 1);
          break;
        case DOWN:
          cell.setLocation(cell.getX(), cell.getY() + 1);
          break;
        case LEFT:
          cell.setLocation(cell.getX() - 1, cell.getY());
          break;
        case RIGHT:
          cell.setLocation(cell.getX() + 1, cell.getY());
          break;
      }

      if (map.getCell(cell) instanceof WallModel
          || cell.getY() <= 0
          || cell.getY() >= map.getMap()[0].length
          || cell.getX() <= 0
          || cell.getX() >= map.getMap().length) {
        return false;
      }
      return true;
    }
  }

  /**
   * Checks for collision between Pacman and ghosts, and decrements Pacman's lives
   * if there is a collision.
   */
  public void checkCollision() {
    // TODO: handle collision when ghosts are vulnerables.
    Point pacPos = this.pacman.getPosition().getLocation();

    for (GhostModel ghost : this.ghosts) {
      Point ghostPos = ghost.getPosition().getLocation();
      if (pacPos.getX() == ghostPos.getX() && pacPos.getY() == ghostPos.getY()) {
        this.pacman.setLives(this.pacman.getLives() - 1);
        System.out.printf("[GCtrl] %s touched %s, he now have %d lives.%n", pacman.getClass().getSimpleName(),
            ghost.getClass().getSimpleName(), pacman.getLives());
      }
    }
  }

  /**
   * Spawns a fruit item on the game map if certain conditions are met.
   * 
   * @param fruits a list of FruitModel objects to choose from for spawning
   */
  public void spawnItem(List<FruitModel> fruits) {
    int dots = this.map.getDot();

    if (dots % 70 == 0 && dots / 70 <= fruits.size() && !FruitModel.isPlaced()) {
      FruitModel fruit = fruits.get(dots / 70);
      ItemModel[][] map = this.map.getMap();
      List<Point> freeCells = new ArrayList<>();

      for (int i = 0; i < map.length; i++) {
        for (int j = 0; j < map[i].length; j++) {
          if (map[i][j] == null) {
            List<Point> spawn = this.map.getSpawn();
            for (Point cell : spawn) {
              if (new Point(i, j) != cell) {
                freeCells.add(new Point(i, j));
              }
            }
          }
        }
      }

      int randInt = 0 + (int) (Math.random() + freeCells.size());
      this.map.setCell(freeCells.get(randInt), fruit);
      fruit.setPosition(freeCells.get(randInt));
      fruit.setExpire();
      FruitModel.setPlaced(true);
    }
  }
}
