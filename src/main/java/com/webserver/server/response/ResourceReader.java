package com.webserver.server.response;

import com.webserver.exceptions.BadRequestException;
import com.webserver.server.request.Request;

import java.io.*;
import java.util.StringJoiner;

public class ResourceReader {
  private String webappPath;

  public ResourceReader(String webappPath) {
    this.webappPath = webappPath;
  }

  public String readResource(String uri) throws IOException {
    try(BufferedReader fileReader = new BufferedReader(new InputStreamReader(new FileInputStream(webappPath + uri)))){
      StringJoiner result = new StringJoiner("\n");
      fileReader.lines().forEach(result::add);
      return result.toString();
    } catch (FileNotFoundException ex){
      throw new BadRequestException(ex.getMessage());
    }
  }
}
