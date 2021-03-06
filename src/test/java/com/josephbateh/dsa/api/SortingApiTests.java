package com.josephbateh.dsa.api;

import com.josephbateh.dsa.service.resources.SortRequest;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;


class SortingApiTests extends BaseApiTest {
  private static final String BASE_PATH = "/sort";
  private List<Integer> list = Arrays.asList(-1, 0, 1);

  @Test
  void testBubbleSortReturnsWithSortedValues() {
    SortRequest sortRequest = new SortRequest(list);

    given()
            .body(sortRequest)
            .when()
            .post(BASE_PATH.concat("/bubble"))
            .then()
            .assertThat()
            .statusCode(200)
            .body("result", is(list));
  }

  @Test
  void testInsertionSortReturnsWithSortedValues() {
    SortRequest sortRequest = new SortRequest(list);

    given()
            .body(sortRequest)
            .when()
            .post(BASE_PATH.concat("/insertion"))
            .then()
            .assertThat()
            .statusCode(200)
            .body("result", is(list));
  }

  @Test
  void testMergeSortReturnsWithSortedValues() {
    SortRequest sortRequest = new SortRequest(list);

    given()
            .body(sortRequest)
            .when()
            .post(BASE_PATH.concat("/merge"))
            .then()
            .assertThat()
            .statusCode(200)
            .body("result", is(list));
  }

  @Test
  void testSelectionSortReturnsWithSortedValues() {
    SortRequest sortRequest = new SortRequest(list);

    given()
            .body(sortRequest)
            .when()
            .post(BASE_PATH.concat("/selection"))
            .then()
            .assertThat()
            .statusCode(200)
            .body("result", is(list));
  }

  @Test
  void testQuickSortReturnsWithSortedValues() {
    SortRequest sortRequest = new SortRequest(list);

    given()
            .body(sortRequest)
            .when()
            .post(BASE_PATH.concat("/quick"))
            .then()
            .assertThat()
            .statusCode(200)
            .body("result", is(list));
  }

  @Test
  void testHeapSortReturnsWithSortedValues() {
    SortRequest sortRequest = new SortRequest(list);

    given()
            .body(sortRequest)
            .when()
            .post(BASE_PATH.concat("/heap"))
            .then()
            .assertThat()
            .statusCode(200)
            .body("result", is(list));
  }
}
