package com.josephbateh.dsa.unit;

import com.josephbateh.dsa.domain.sorting.algorithms.SelectionSort;
import com.josephbateh.dsa.helpers.RandomGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SelectionSortTests {
  private List<Integer> list = new ArrayList<>();
  private List<Integer> expectedList = new ArrayList<>();

  @BeforeEach
  void beforeAll() {
    list = RandomGenerator.generateRandomIntegers(100);
    // Need deep copy
    expectedList.addAll(list);
    Collections.sort(expectedList);
  }

  @Test
  void testSort() {
    List<Integer> actualList = SelectionSort.sort(list).getResult();
    assertEquals(expectedList, actualList);
  }
}
