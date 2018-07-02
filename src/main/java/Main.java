import java.io.IOException;

public class Main {
  public static void main(String[] args) throws IOException {

    try {
      SecretManager.run();
    } catch (Exception e) {
      e.printStackTrace();
    }


  }
}
