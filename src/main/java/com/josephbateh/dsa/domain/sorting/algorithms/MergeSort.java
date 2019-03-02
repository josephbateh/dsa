package com.josephbateh.dsa.domain.sorting.algorithms;

import com.josephbateh.dsa.helpers.Timer;
import com.josephbateh.dsa.service.resources.SortResponse;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MergeSort {
  public static SortResponse sort(List<Integer> list) {
    Timer timer = new Timer();
    timer.start();

    List<Integer> sortedList = mergeSort(list);

    long duration = timer.stop();
    return new SortResponse(duration, sortedList);
  }

  private static List<Integer> mergeSort(List<Integer> list) {
    if (list.size() < 2) {
      return list;
    }

    int leftIndex = 0;
    int rightIndex = list.size();
    int middleIndex = ((leftIndex + rightIndex)) / 2;

    List<Integer> leftList = list.subList(leftIndex, middleIndex);
    List<Integer> rightList = list.subList(middleIndex, rightIndex);

    return merge(mergeSort(leftList), mergeSort(rightList));
  }

  private static List<Integer> merge(List<Integer> leftArray, List<Integer> rightArray) {
    Iterator<Integer> leftIterator = leftArray.iterator();
    Iterator<Integer> rightIterator = rightArray.iterator();
    List<Integer> mergedList = new ArrayList<>();

    // Pending variables needed because values can still be added when both iterators have no next value
    Integer left = leftIterator.next();
    Integer right = rightIterator.next();
    boolean leftPending = true;
    boolean rightPending = true;

    while (leftPending || rightPending) {
      if (left <= right) {
        mergedList.add(left);
        if (leftIterator.hasNext()) {
          left = leftIterator.next();
        } else {
          left = Integer.MAX_VALUE;
          leftPending = false;
        }
      } else {
        mergedList.add(right);
        if (rightIterator.hasNext()) {
          right = rightIterator.next();
        } else {
          right = Integer.MAX_VALUE;
          rightPending = false;
        }
      }
    }

    return mergedList;
  }
}

