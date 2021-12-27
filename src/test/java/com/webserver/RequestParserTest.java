package com.webserver;

import com.webserver.server.request.HttpMethod;
import com.webserver.server.request.Request;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RequestParserTest {
  @Test
  public void testInjectUriAndMethod() {
    // test html-page
    String requestLineHtml = "GET /index.html HTTP/1.1";
    String expectedUriHtml = "/index.html";
    HttpMethod expectedMethodHtml = HttpMethod.GET;

    Request requestHtml = new Request();
    // for testing should make method is public
//    RequestParser.injectUriAndMethod(requestLineHtml, requestHtml);
    assertEquals(expectedUriHtml, requestHtml.getUri());
    assertEquals(expectedMethodHtml, requestHtml.getMethod());

    // test api request
    String requestLineApi = "POST /api/v1/users?id=1&currency=usd HTTP/1.1";
    String expectedUriApi = "/api/v1/users?id=1&currency=usd";
    HttpMethod expectedMethodApi = HttpMethod.POST;

    Request requestApi = new Request();
//    RequestParser.injectUriAndMethod(requestLineApi, requestApi);
    assertEquals(expectedUriApi, requestApi.getUri());
    assertEquals(expectedMethodApi, requestApi.getMethod());
  }
}
