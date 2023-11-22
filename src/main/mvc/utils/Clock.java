package src.main.mvc.utils;

import java.time.Duration;
import java.time.LocalTime;

/**
 * A class representing a clock that can measure elapsed time in minutes,
 * seconds, and milliseconds.
 */
public class Clock {
  private LocalTime timer;

  public Clock() {
    this.timer = LocalTime.now();
  }

  public long getMin() {
    return Duration.between(this.timer, LocalTime.now()).toMinutes();
  }

  public long getSec() {
    return Duration.between(this.timer, LocalTime.now()).toSeconds();
  }

  public long getMs() {
    return Duration.between(this.timer, LocalTime.now()).toMillis();
  }

  public void reset() {
    this.timer = LocalTime.now();
  }
}
