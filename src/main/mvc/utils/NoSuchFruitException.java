package src.main.mvc.utils;

/**
 * This exception is thrown when a requested fruit is not found.
 */
public class NoSuchFruitException extends Exception {
  public NoSuchFruitException(String message) {
    super(message);
  }
}
