package com.josephbateh.dsa.domain.sorting;

import com.josephbateh.dsa.helpers.Timer;
import com.josephbateh.dsa.service.resources.SortResponse;

import java.util.List;

public class QuickSort {
  public static SortResponse sort(List<Integer> list) {
    Timer timer = new Timer();
    timer.start();
    long duration = timer.stop();
    return new SortResponse(duration, list);
  }
}
