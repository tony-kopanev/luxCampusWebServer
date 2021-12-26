package com.webserver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class RequestHandler {
  private BufferedReader socketReader;
  private BufferedWriter socketWriter;
  private String webappPath;

  public RequestHandler(
          BufferedReader socketReader,
          BufferedWriter socketWriter,
          String webappPath
  ) {
    this.socketReader = socketReader;
    this.socketWriter = socketWriter;
    this.webappPath = webappPath;
  }

  public void handle() throws IOException {
    Request request = RequestParser.parse(socketReader);
    ResourceReader resourceReader = new ResourceReader(webappPath);
    String content = resourceReader.readResource(request.getUri());
    ResponseWriter.writeSuccessResponse(content, socketWriter);
  }
}
