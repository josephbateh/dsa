package com.josephbateh.dsa.api;

import com.josephbateh.dsa.service.resources.HeapRequest;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;


class HeapApiTests extends BaseApiTest {
  private static final String BASE_PATH = "/heap";
  private List<Integer> list = Arrays.asList(-1, 0, 1);

  @Test
  @Disabled
  void testMinHeapReturnsWithArrayInMinHeapOrder() {
    HeapRequest heapRequest = new HeapRequest(list);

    given()
            .body(heapRequest)
            .when()
            .post(BASE_PATH.concat("/min"))
            .then()
            .assertThat()
            .statusCode(200)
            .body("result", is(list));
  }

  @Test
  @Disabled
  void testMaxHeapReturnsWithArrayInMaxHeapOrder() {
    HeapRequest heapRequest = new HeapRequest(list);

    given()
            .body(heapRequest)
            .when()
            .post(BASE_PATH.concat("/max"))
            .then()
            .assertThat()
            .statusCode(200)
            .body("result", is(list));
  }
}
