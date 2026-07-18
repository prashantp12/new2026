package Practice;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class Test1 {

    public static void main(String[] args) throws FileNotFoundException {
       try {
           FileReader file = new FileReader("test.txt");
       }catch (Exception e){
           System.out.println(e.getMessage());
       }

    }
}
