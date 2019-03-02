package com.josephbateh.dsa.unit;

import com.josephbateh.dsa.helpers.RandomGenerator;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RandomGeneratorTests {
  @Test
  void testPositiveValueReturnsListWithSizeEqualToValue() {
    List<Integer> list = RandomGenerator.generateRandomIntegers(1);
    assertEquals(1, list.size());
  }

  @Test
  void testNegativeValueReturnsEmptyList() {
    List<Integer> list = RandomGenerator.generateRandomIntegers(-1);
    assertEquals(new ArrayList<Integer>(), list);
  }

  @Test
  void testZeroValueReturnsEmptyList() {
    List<Integer> list = RandomGenerator.generateRandomIntegers(0);
    assertEquals(new ArrayList<Integer>(), list);
  }
}
