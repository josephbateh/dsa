package com.josephbateh.dsa.helpers;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomGenerator {
  public static List<Integer> generateRandomIntegers(int numberOfIntegers) {
    List<Integer> list = new ArrayList<>();
    Random random = new Random();
    for (int i = 0; i < numberOfIntegers; i++) {
      list.add(random.nextInt());
    }
    return list;
  }
}
