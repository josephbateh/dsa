package com.josephbateh.dsa.domain.sorting;

import com.josephbateh.dsa.helpers.Timer;
import com.josephbateh.dsa.service.resources.SortResponse;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SelectionSort {
  public static SortResponse sort(List<Integer> list) {
    int[] listArray = list.stream().mapToInt(i -> i).toArray();

    Timer timer = new Timer();
    timer.start();

    // Iterate over length of array
    for (int outerIndex = 0; outerIndex < listArray.length; outerIndex++) {
      int lowestValue = listArray[outerIndex];
      int lowestValueIndex = outerIndex;

      // Iterate from current index to end of array
      for (int innerIndex = outerIndex; innerIndex < listArray.length; innerIndex++) {
        if (listArray[innerIndex] < lowestValue) {
          lowestValue = listArray[innerIndex];
          lowestValueIndex = innerIndex;
        }
      }

      // Swap values
      int currentValue = listArray[outerIndex];
      listArray[outerIndex] = listArray[lowestValueIndex];
      listArray[lowestValueIndex] = currentValue;
    }

    long duration = timer.stop();
    List<Integer> responseList = Arrays.stream(listArray).boxed().collect(Collectors.toList());
    return new SortResponse(duration, responseList);
  }
}
