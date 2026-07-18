import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class SetExample {

    static void main(String[] args) {
        Map<Integer, String> ex = new LinkedHashMap<>();
        ex.put(10, "Java");
        ex.put(20, "Java");
        ex.put(30, "sql");
        ex.put(40, ".net");
        ex.put(50, "sales");
        ex.put(50, "fire");
        ex.put(null, "temp");
        ex.put(60, null);
        ex.put(70, null);
        System.out.println(ex);
    }
}
