package src.main.mvc.utils;

/**
 * Exception thrown when the dimensions of a map schema are invalid.
 */
public class BadDimensionsException extends Exception {
  public BadDimensionsException(String message) {
    super(message);
  }
}
