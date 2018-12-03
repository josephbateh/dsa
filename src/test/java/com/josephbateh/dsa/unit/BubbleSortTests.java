package com.josephbateh.dsa.unit;

import com.josephbateh.dsa.domain.sorting.algorithms.BubbleSort;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BubbleSortTests {
  private List<Integer> list = Arrays.asList(16, 18, 13, 5, 20, 12, 9, 2, 10, 7);
  private List<Integer> expectedList = Arrays.asList(2, 5, 7, 9, 10, 12, 13, 16, 18, 20);

  @Test
  void testSort() {
    List<Integer> actualList = BubbleSort.sort(list).getResult();
    assertEquals(expectedList, actualList);
  }
}
