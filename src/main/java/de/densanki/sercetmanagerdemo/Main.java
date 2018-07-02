package de.densanki.sercetmanagerdemo;

import java.io.IOException;

public class Main {
  public static void main(String[] args) throws IOException {

    try {
      //RetriveSecret.run();
      ListSecrets.run();
    } catch (Exception e) {
      e.printStackTrace();
    }

  }
}
