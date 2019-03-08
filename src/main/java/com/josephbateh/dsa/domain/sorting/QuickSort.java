package com.josephbateh.dsa.domain.sorting;

import com.josephbateh.dsa.helpers.Timer;
import com.josephbateh.dsa.service.resources.SortResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class QuickSort {
  public static SortResponse sort(List<Integer> list) {
    Timer timer = new Timer();
    timer.start();

    List<Integer> sortedListed = quickSort(list);

    long duration = timer.stop();
    return new SortResponse(duration, sortedListed);
  }

  // Efficiency plummets if not ArrayList
  private static List<Integer> quickSort(List<Integer> list) {
    if (list.size() < 2) {
      return list;
    }

    int left = 0;
    int right = list.size() - 1;
    Random rand = new Random();
    int pivot = rand.nextInt(list.size());
    int pivotValue = list.get(pivot);

    boolean leftSwap = false;
    boolean rightSwap = false;
    while (left < right) {
      int leftValue = list.get(left);
      int rightValue = list.get(right);

      if (leftValue >= pivotValue) {
        leftSwap = true;
      }

      if (rightValue < pivotValue) {
        rightSwap = true;
      }

      if (leftSwap && rightSwap) {
        list.set(left, rightValue);
        list.set(right, leftValue);
        leftSwap = false;
        rightSwap = false;
      }

      if (!leftSwap) {
        left++;
      } else {
        right--;
      }
    }

    List<Integer> leftList = quickSort(list.subList(0, right));
    List<Integer> rightList = quickSort(list.subList(right, list.size()));
    List<Integer> assembledList = new ArrayList<>();
    assembledList.addAll(leftList);
    assembledList.addAll(rightList);

    return assembledList;
  }
}
