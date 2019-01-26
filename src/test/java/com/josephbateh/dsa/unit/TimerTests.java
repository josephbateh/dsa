package com.josephbateh.dsa.unit;

import com.josephbateh.dsa.helpers.Timer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TimerTests {
  private Timer timer;

  @BeforeEach
  void beforeEach() {
    timer = new Timer();
  }

  @Test
  void durationIsGreaterThanZero() {
    timer.start();
    long duration = timer.stop();
    assertTrue(duration > 0);
  }

  @Test
  void timerIsZeroWhenNotStarted() {
    long duration = timer.stop();
    assertEquals(0, duration);
  }
}
