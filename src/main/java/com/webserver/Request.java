package com.webserver;

import java.util.HashMap;

public class Request {
  private HttpMethod method;
  private String uri;
  private HashMap<String, String> headers;

  public HttpMethod getMethod() {
    return method;
  }

  public String getUri() {
    return uri;
  }

  public HashMap<String, String> getHeaders() {
    return headers;
  }

  public void setMethod(HttpMethod method) {
    this.method = method;
  }

  public void setUri(String uri) {
    this.uri = uri;
  }

  public void setHeaders(HashMap<String, String> headers) {
    this.headers = headers;
  }
}

enum HttpMethod { GET, POST; }
