package com.josephbateh.dsa.service;

import com.josephbateh.dsa.domain.sorting.algorithms.BubbleSort;
import com.josephbateh.dsa.service.resources.SortRequest;
import com.josephbateh.dsa.service.resources.SortResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/sorting", produces = MediaType.APPLICATION_JSON_VALUE)
public class SortingController {
  protected static Logger log = LoggerFactory.getLogger(SortingController.class);

  @RequestMapping(method = RequestMethod.POST, value = "/bubble")
  @ResponseStatus(value = HttpStatus.OK)
  public SortResponse bubble(@RequestBody SortRequest request) {
    log.info("Sorting {} integers with bubble sort", request.getList().size());
    SortResponse response = BubbleSort.sort(request.getList());
    log.info("Completed sorting {} integers with bubble sort in {} nanoseconds", request.getList().size(),   response.getNanoDuration());
    return BubbleSort.sort(request.getList());
  }
}
