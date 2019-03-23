package com.josephbateh.dsa.service;

import com.josephbateh.dsa.domain.heap.MinHeap;
import com.josephbateh.dsa.helpers.Timer;
import com.josephbateh.dsa.service.resources.HeapRequest;
import com.josephbateh.dsa.service.resources.HeapResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/heap", produces = MediaType.APPLICATION_JSON_VALUE)
public class HeapController {
  protected static Logger log = LoggerFactory.getLogger(HeapController.class);

  @RequestMapping(method = RequestMethod.POST, value = "/min")
  @ResponseStatus(value = HttpStatus.OK)
  public HeapResponse minHeap(@RequestBody HeapRequest request) {
    Timer timer = new Timer();
    timer.start();

    log.info("Adding {} integers to a min heap", request.getList().size());
    MinHeap heap = new MinHeap(request.getList().toArray(new Integer[0]));
    long duration = timer.stop();
    log.info("Finished adding {} integers to a min heap", request.getList().size());

    List<Integer> list = new ArrayList<>();
    while (heap.hasElements()) {
      list.add(heap.pop());
    }

    return new HeapResponse(duration, list);
  }

  @RequestMapping(method = RequestMethod.POST, value = "/max")
  @ResponseStatus(value = HttpStatus.OK)
  public ResponseEntity<HeapResponse> maxHeap(@RequestBody HeapRequest request) {
    log.info("Adding {} integers to a max heap", request.getList().size());
    return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
  }
}
