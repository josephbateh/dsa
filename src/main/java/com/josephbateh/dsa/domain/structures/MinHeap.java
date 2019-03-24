package com.josephbateh.dsa.domain.structures;

public class MinHeap {
  private static final int INITIAL_SIZE = 2;

  private Integer[] elements;
  private int lastElementIndex;
  private final int SMALLEST_ITEM = 1;

  public MinHeap(Integer... elements) {
    this.elements = new Integer[INITIAL_SIZE];
    lastElementIndex = 0;
    this.elements[lastElementIndex] = Integer.MIN_VALUE;
    insert(elements);
  }

  public void insert(Integer... elements) {
    for (Integer element : elements) {
      addElementToEndOfArray(element);
      bubbleUp(lastElementIndex);
    }
  }

  public Integer peek() {
    return elements[SMALLEST_ITEM];
  }

  public Integer pop() {
    // Get the first element
    Integer poppedElement = elements[SMALLEST_ITEM];

    // Get the last element and decrement lastElementIndex
    Integer lastElement = elements[lastElementIndex--];

    // Put the lastElement as the first element
    elements[SMALLEST_ITEM] = lastElement;

    // Bubble down to put the element in the correct spot
    bubbleDown(SMALLEST_ITEM);

    // Contract the array if we've removed enough elements
    contractIfLessThanHalfUtilization();
    return poppedElement;
  }

  public boolean isEmpty() {
    return lastElementIndex <= 0;
  }

  public boolean hasElements() {
    return !isEmpty();
  }

  private void bubbleUp(int childIndex) {
    int parentIndex = getParent(childIndex);
    if (parentIndex < 0) {
      // child is root
      return;
    }

    Integer child = elements[childIndex];
    Integer parent = elements[parentIndex];

    if (parent > child) {
      elements[parentIndex] = child;
      elements[childIndex] = parent;
      bubbleUp(parentIndex);
    }
  }

  private void bubbleDown(int parentIndex) {
    // Get child values
    Integer leftChildValue = getLeftChildValue(parentIndex);
    Integer rightChildValue = getRightChildValue(parentIndex);

    // Determine if children exist
    boolean leftChildExists = leftChildValue != null;
    boolean rightChildExists = rightChildValue != null;

    // Must have child to swap
    if (leftChildExists) {

      // If right child does not exist, swap with left child
      if (!rightChildExists) {
        swapIfGreaterThanChild(parentIndex, getLeftChildIndex(parentIndex));
      } else {
        // If right child exists, swap with lesser child
        if (leftChildValue < rightChildValue) {
          swapIfGreaterThanChild(parentIndex, getLeftChildIndex(parentIndex));
        } else {
          swapIfGreaterThanChild(parentIndex, getRightChildIndex(parentIndex));
        }
      }
    }
  }

  private void swapIfGreaterThanChild(int parentIndex, int childIndex) {
    Integer parent = elements[parentIndex];
    if (childIndex <= lastElementIndex) {
      Integer childValue = elements[childIndex];
      if (childValue != null && parent > childValue) {
        elements[parentIndex] = childValue;
        elements[childIndex] = parent;
        bubbleDown(childIndex);
      }
    }
  }

  private int getParent(int childIndex) {
    return childIndex / 2;
  }

  private int getLeftChildIndex(int parentIndex) {
    return (parentIndex * 2);
  }

  private int getRightChildIndex(int parentIndex) {
    return (parentIndex * 2) + 1;
  }

  // Get left child, return null if no child
  private Integer getLeftChildValue(int parentIndex) {
    try {
      int leftChildIndex = getLeftChildIndex(parentIndex);
      return elements[leftChildIndex];
    } catch (IndexOutOfBoundsException e) {
      return null;
    }
  }

  // Get right child, return null if no child
  private Integer getRightChildValue(int parentIndex) {
    try {
      int rightChildIndex = getRightChildIndex(parentIndex);
      return elements[rightChildIndex];
    } catch (IndexOutOfBoundsException e) {
      return null;
    }
  }

  private void addElementToEndOfArray(Integer element) {
    expandArrayIfFull();

    // Add element to array at next index
    elements[++lastElementIndex] = element;
  }

  private void expandArrayIfFull() {
    if (elements.length != lastElementIndex + 1) {
      return;
    }
    Integer[] newArray = new Integer[elements.length * 2];
    System.arraycopy(elements, 0, newArray, 0, elements.length);
    elements = newArray;
  }

  private void contractIfLessThanHalfUtilization() {
    if (elements.length / 2 <= lastElementIndex) {
      return;
    }
    int newLength = elements.length / 2;
    Integer[] newArray = new Integer[newLength];
    System.arraycopy(elements, 0, newArray, 0, newLength);
    elements = newArray;
  }
}
