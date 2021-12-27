package com.webserver.server.response;

import java.io.BufferedWriter;
import java.io.IOException;

public class ResponseWriter {
  public static void writeSuccessResponse(String content, BufferedWriter writer) throws IOException {
    writer.write("HTTP/1.1 200 OK");
    writer.newLine();
    writer.newLine();
    writer.write(content);
    writer.flush();
    System.out.println("Request obtained");
  }
}