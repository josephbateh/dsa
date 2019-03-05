package com.josephbateh.dsa.service;

import com.josephbateh.dsa.service.resources.HeapRequest;
import com.josephbateh.dsa.service.resources.HeapResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/heap", produces = MediaType.APPLICATION_JSON_VALUE)
public class HeapController {
  protected static Logger log = LoggerFactory.getLogger(HeapController.class);

  @RequestMapping(method = RequestMethod.POST, value = "/min")
  @ResponseStatus(value = HttpStatus.OK)
  public ResponseEntity<HeapResponse> minHeap(@RequestBody HeapRequest request) {
    log.info("Adding {} integers to a min heap", request.getList().size());
    return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
  }

  @RequestMapping(method = RequestMethod.POST, value = "/max")
  @ResponseStatus(value = HttpStatus.OK)
  public ResponseEntity<HeapResponse> maxHeap(@RequestBody HeapRequest request) {
    log.info("Adding {} integers to a max heap", request.getList().size());
    return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
  }
}
