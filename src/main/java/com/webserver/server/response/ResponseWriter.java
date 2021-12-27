package com.webserver.server.response;

import java.io.BufferedWriter;
import java.io.IOException;

public class ResponseWriter {
  private static final String NOT_FOUND_ERROR_MESSAGE = "Page 404: Not able to find the file with specified path";

  public static void writeSuccessResponse(String content, BufferedWriter writer) throws IOException {
    writer.write("HTTP/1.1 200 OK");
    writer.newLine();
    writer.newLine();
    writer.write(content);
    writer.flush();
//    System.out.println("Request obtained");
  }

  public static void writeBadRequestResponse(BufferedWriter writer) throws IOException {
    writer.write("HTTP/1.1 404 Not Found");
    writer.newLine();
    writer.newLine();
    writer.write(NOT_FOUND_ERROR_MESSAGE);
  }
}