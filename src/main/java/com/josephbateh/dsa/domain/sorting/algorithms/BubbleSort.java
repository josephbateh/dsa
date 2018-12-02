package com.josephbateh.dsa.domain.sorting.algorithms;

import com.josephbateh.dsa.service.resources.SortResponse;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BubbleSort {
  public static SortResponse sort(List<Integer> list) {
    int[] arr = list.stream().mapToInt(i -> i).toArray();
    int n = arr.length;
    long startTime = System.nanoTime();
    for (int i = 0; i < n - 1; i++) {
      for (int j = 0; j < n - i - 1; j++) {
        if (arr[j] > arr[j + 1]) {
          int temp = arr[j];
          arr[j] = arr[j + 1];
          arr[j + 1] = temp;
        }
      }
    }
    long endTime = System.nanoTime();
    long duration = endTime - startTime;
    List<Integer> responseList = Arrays.stream(arr).boxed().collect(Collectors.toList());
    return new SortResponse(duration, responseList);
  }
}
