package com.josephbateh.dsa.service;

import com.josephbateh.dsa.service.resources.SortRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/sorting", produces = MediaType.APPLICATION_JSON_VALUE)
public class SortingController {
  protected static Logger log = LoggerFactory.getLogger(SortingController.class);

  @RequestMapping(method = RequestMethod.PUT, value = "/bubble")
  @ResponseStatus(value = HttpStatus.OK)
  public ResponseEntity<Void> bubbleSort(@RequestBody SortRequest request) {

    log.info("Sorting with bubble sort");

    return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
  }
}
