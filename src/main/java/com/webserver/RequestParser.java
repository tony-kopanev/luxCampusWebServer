package com.webserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;

public class RequestParser {

  public static Request parse(BufferedReader reader) throws IOException {
    Request request = new Request();
    injectUriAndMethod(reader.readLine(), request);
    injectHeaders(reader, request);

    return request;
  }

  private static void injectUriAndMethod(String line, Request request){
    String[] uriData = line.split(" ");
    request.setMethod(HttpMethod.valueOf(uriData[0]));
    request.setUri(uriData[1]);
  }

  private static void injectHeaders(BufferedReader reader, Request request){
    HashMap<String, String> headers = new HashMap<>();

    // fill headers
    reader.lines().forEach(header -> {
      String[] headerData = header.split(": ");
      if(headerData.length > 1) {
        headers.put(headerData[0], headerData[1]);
      }
    });

    request.setHeaders(headers);
  }
}


