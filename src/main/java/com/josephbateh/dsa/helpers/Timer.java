package com.josephbateh.dsa.helpers;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Timer {
  private long startTime;
  private long endTime;
  private long duration;

  /**
   * Record the start time.
   */
  public void start() {
    startTime = System.nanoTime();
  }

  /**
   * Record the end time and calculate the duration.
   *
   * @return the duration of a timer run
   */
  public long stop() {
    // Handles the case of stopping without starting
    if (startTime == 0) {
      return startTime;
    }

    endTime = System.nanoTime();
    duration = endTime - startTime;
    return duration;
  }
}
