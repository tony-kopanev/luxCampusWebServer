package com.webserver.server.request;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Objects;

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

  private static void injectHeaders(BufferedReader reader, Request request) throws IOException {
    HashMap<String, String> headers = new HashMap<>();

    // fill headers
    while (reader.ready()){
      String line = reader.readLine();
      if(Objects.isNull(line)) continue;

      String[] headerData = line.split(": ");
      if(headerData.length > 1){
        headers.put(headerData[0], headerData[1]);
      }
    }

    request.setHeaders(headers);
  }
}


