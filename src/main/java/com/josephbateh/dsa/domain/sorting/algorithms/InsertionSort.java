package com.josephbateh.dsa.domain.sorting.algorithms;

import com.josephbateh.dsa.helpers.Timer;
import com.josephbateh.dsa.service.resources.SortResponse;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InsertionSort {
  public static SortResponse sort(List<Integer> list) {
    int[] listArray = list.stream().mapToInt(i -> i).toArray();
    int arrayLength = listArray.length;

    Timer timer = new Timer();
    timer.start();

    for (int index = 1; index < arrayLength; ++index) {
      // Current location in array
      int currentElement = listArray[index];

      // Previous element in array
      int previousElement = index - 1;

      // While previous element > current element move forward one index
      while (previousElement >= 0 && listArray[previousElement] > currentElement) {
        listArray[previousElement + 1] = listArray[previousElement];
        previousElement = previousElement - 1;
      }

      // Store current element in open space
      listArray[previousElement + 1] = currentElement;
    }

    long duration = timer.stop();
    List<Integer> responseList = Arrays.stream(listArray).boxed().collect(Collectors.toList());
    return new SortResponse(duration, responseList);
  }
}
