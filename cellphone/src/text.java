import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class text {
  public static void main(String[] args) {
    try {
      BufferedWriter writer = new BufferedWriter(new FileWriter("adminAccount.txt"));
      writer.write("haha 1 2 3 4 hoang nguyen iu lia");
      writer.close();
    } catch (IOException e) {
      e.printStackTrace();
    }

    try {
      BufferedReader reader = new BufferedReader(new FileReader("adminAccount.txt"));
      System.out.println(reader.readLine());
      reader.close();
    } catch (IOException e) {

      e.printStackTrace();
    }
  }

}
