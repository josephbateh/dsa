package com.josephbateh.dsa.domain.sorting.algorithms;

import com.josephbateh.dsa.helpers.Timer;
import com.josephbateh.dsa.service.resources.SortResponse;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BubbleSort {
  public static SortResponse sort(List<Integer> list) {
    int[] listArray = list.stream().mapToInt(i -> i).toArray();
    int arrayLength = listArray.length;

    Timer timer = new Timer();
    timer.start();

    for (int currentIndex = 0; currentIndex < arrayLength - 1; currentIndex++) {
      for (int previousIndex = 0; previousIndex < arrayLength - currentIndex - 1; previousIndex++) {
        // If previous element is greater than current element, swap
        if (listArray[previousIndex] > listArray[previousIndex + 1]) {
          int previousElement = listArray[previousIndex];
          listArray[previousIndex] = listArray[previousIndex + 1];
          listArray[previousIndex + 1] = previousElement;
        }
      }
    }

    long duration = timer.stop();
    List<Integer> responseList = Arrays.stream(listArray).boxed().collect(Collectors.toList());
    return new SortResponse(duration, responseList);
  }
}
