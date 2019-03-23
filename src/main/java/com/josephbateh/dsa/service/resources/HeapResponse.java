package com.josephbateh.dsa.service.resources;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class HeapResponse {
  private long duration;
  private List<Integer> array;
}
