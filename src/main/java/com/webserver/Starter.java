package com.webserver;

import com.webserver.server.Server;

public class Starter {
  public static void main(String[] args) throws Exception {
    Server server = new Server();
    server.setPort(3000);
    server.setWebAppPath("src/main/resources/webapp/");
    server.start();
  }
}
