package com.webserver.server.response;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.StringJoiner;

public class ResourceReader {
  private String webappPath;

  public ResourceReader(String webappPath) {
    this.webappPath = webappPath;
  }

  public String readResource(String uri) throws FileNotFoundException {
    BufferedReader fileReader = new BufferedReader(new InputStreamReader(new FileInputStream(webappPath + uri)));
    StringJoiner result = new StringJoiner("\n");
    fileReader.lines().forEach(result::add);

    return result.toString();
  }
}
