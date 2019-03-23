package com.josephbateh.dsa.unit;

import com.josephbateh.dsa.domain.heap.MinHeap;
import com.josephbateh.dsa.helpers.RandomGenerator;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HeapAlgorithmTests {
  @RepeatedTest(10)
  void testInsertRandomElements() {
    // Given heap of random elements
    List<Integer> list = RandomGenerator.generateRandomIntegers(10);
    MinHeap heap = new MinHeap(list.toArray(new Integer[0]));

    // Sort list after creating heap with values
    Collections.sort(list);

    List<Integer> poppedElements = new ArrayList<>();
    while (heap.hasElements()) {
      poppedElements.add(heap.pop());
    }

    assertEquals(list, poppedElements);
  }

  @Test
  void testInsertElementSmallerThanMin() {
    // Given heap of elements
    List<Integer> list = Arrays.asList(-1, 0, 1);
    MinHeap heap = new MinHeap(list.toArray(new Integer[0]));
    Integer expectedValue = -2;

    // When an element smaller than any in the heap is inserted
    heap.insert(expectedValue);

    // Then smallest element is at the root
    Integer actualValue = heap.peek();
    assertEquals(expectedValue, actualValue);
  }

  @Test
  void testInsertElementLargerThanMin() {
    // Given heap of elements
    List<Integer> list = Arrays.asList(-1, 0, 1);
    MinHeap heap = new MinHeap(list.toArray(new Integer[0]));
    Integer expectedValue = -1;
    Integer largerValue = 2;


    // When element inserted that is larger than the smallest in the heap
    heap.insert(largerValue);

    // Then the smallest element remains
    Integer actualValue = heap.peek();
    assertEquals(expectedValue, actualValue);
  }

  @Test
  void testElementsInsertedIntoArrayAscending() {
    // Given a heap of elements
    List<Integer> list = new ArrayList<>();
    for (int i = 0; i < 100; i++) {
      list.add(i);
    }
    MinHeap heap = new MinHeap(list.toArray(new Integer[0]));

    // When smallest element is removed until heap is empty
    List<Integer> poppedElements = new ArrayList<>();
    while (heap.hasElements()) {
      poppedElements.add(heap.pop());
    }

    // Then the list of elements removed is sorted from smallest to highest
    assertEquals(list, poppedElements);
  }

  @Test
  void testElementsInsertedIntoArrayDescending() {
    // Given a heap of elements
    List<Integer> list = new ArrayList<>();
    for (int i = 100; i > 0; i--) {
      list.add(i);
    }
    MinHeap heap = new MinHeap(list.toArray(new Integer[0]));
    Collections.sort(list);

    // When smallest element is removed until heap is empty
    List<Integer> poppedElements = new ArrayList<>();
    while (heap.hasElements()) {
      poppedElements.add(heap.pop());
    }

    // Then the list of elements removed is sorted from smallest to highest
    assertEquals(list, poppedElements);
  }

  @Test
  void testPopRemovesElement() {
    // Given heap of elements
    List<Integer> list = Arrays.asList(-1, 0, 1);
    MinHeap heap = new MinHeap(list.toArray(new Integer[0]));

    // When smallest element is popped
    Integer poppedElement = heap.pop();

    // Then the new smallest element should be different
    Integer smallestElement = heap.peek();
    assertNotEquals(poppedElement, smallestElement);
  }

  @Test
  void testIsEmptyWhenEmpty() {
    // Given empty heap
    MinHeap heap = new MinHeap();

    // Then isEmpty should return true
    assertTrue(heap.isEmpty());
  }

  @Test
  void testIsEmptyWhenNotEmpty() {
    // Given not empty heap
    MinHeap heap = new MinHeap(1);

    // Then isEmpty should return true
    assertFalse(heap.isEmpty());
  }

  @Test
  void testHasElementsWhenEmpty() {
    // Given empty heap
    MinHeap heap = new MinHeap();

    // Then hasElements should return false
    assertFalse(heap.hasElements());
  }

  @Test
  void testHasElementsWhenNotEmpty() {
    // Given not empty heap
    MinHeap heap = new MinHeap(1);

    // Then hasElements should return true
    assertTrue(heap.hasElements());
  }
}
