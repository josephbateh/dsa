package com.josephbateh.dsa.unit;

import com.josephbateh.dsa.domain.sorting.*;
import com.josephbateh.dsa.helpers.RandomGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SortingAlgorithmTests {
  private List<Integer> list = new ArrayList<>();
  private List<Integer> expectedList = new ArrayList<>();

  @BeforeEach
  void beforeEach() {
    list = RandomGenerator.generateRandomIntegers(1000);
    // Need deep copy
    expectedList.addAll(list);
    Collections.sort(expectedList);
  }

  @Test
  void testSelectionSort() {
    List<Integer> actualList = SelectionSort.sort(list).getResult();
    assertEquals(expectedList, actualList);
  }

  @Test
  void testBubbleSort() {
    List<Integer> actualList = BubbleSort.sort(list).getResult();
    assertEquals(expectedList, actualList);
  }

  @Test
  void testMergeSort() {
    List<Integer> actualList = MergeSort.sort(list).getResult();
    assertEquals(expectedList, actualList);
  }

  @Test
  void testInsertionSort() {
    List<Integer> actualList = InsertionSort.sort(list).getResult();
    assertEquals(expectedList, actualList);
  }

  @Test
  @Disabled
  void testQuickSort() {
    List<Integer> actualList = QuickSort.sort(list).getResult();
    assertEquals(expectedList, actualList);
  }
}
