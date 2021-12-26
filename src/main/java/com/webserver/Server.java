package com.webserver;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
  private int port;
  private String webAppPath;

  public void setPort(int port) {
    this.port = port;
  }

  public void setWebAppPath(String webAppPath) {
    this.webAppPath = webAppPath;
  }

  public void start() throws Exception {
    try(ServerSocket serverSocket = new ServerSocket(port)){
      while (true){
        try(
            Socket socket = serverSocket.accept();
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))
        ){
          RequestHandler requestHandler = new RequestHandler(reader, writer, webAppPath);
          requestHandler.handle();
  //        break;
        }
      }
    } catch (IOException e) {
      throw new IllegalStateException();
    }
  }
}
