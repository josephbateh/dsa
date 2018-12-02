package com.josephbateh.dsa.domain.sorting.algorithms;

import com.josephbateh.dsa.service.resources.SortResponse;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InsertionSort {
  public static SortResponse sort(List<Integer> list) {
    int[] arr = list.stream().mapToInt(i -> i).toArray();
    int n = arr.length;
    long startTime = System.nanoTime();
    for (int i = 1; i < n; ++i) {
      int key = arr[i];
      int j = i - 1;
      while (j >= 0 && arr[j] > key) {
        arr[j + 1] = arr[j];
        j = j - 1;
      }
      arr[j + 1] = key;
    }
    long endTime = System.nanoTime();
    long duration = endTime - startTime;
    List<Integer> responseList = Arrays.stream(arr).boxed().collect(Collectors.toList());
    return new SortResponse(duration, responseList);
  }
}
