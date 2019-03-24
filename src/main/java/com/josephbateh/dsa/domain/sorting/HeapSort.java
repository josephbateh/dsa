package com.josephbateh.dsa.domain.sorting;

import com.josephbateh.dsa.domain.structures.MinHeap;
import com.josephbateh.dsa.helpers.Timer;
import com.josephbateh.dsa.service.resources.SortResponse;

import java.util.LinkedList;
import java.util.List;

public class HeapSort {
  public static SortResponse sort(List<Integer> list) {
    Timer timer = new Timer();
    timer.start();

    MinHeap heap = new MinHeap(list.toArray(new Integer[0]));
    List<Integer> sortedList = new LinkedList<>();

    while (heap.hasElements()) {
      sortedList.add(heap.pop());
    }

    long duration = timer.stop();
    return new SortResponse(duration, sortedList);
  }
}
