package Practice;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.concurrent.CopyOnWriteArrayList;

public class ArrayListExample {

    static void main(String[] args) {

        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(100);
        arr.add(200);
        arr.add(300);
        arr.add(400);
        arr.add(500);

        Collection<Integer> arr1 = Collections.synchronizedList(arr);
        System.out.println(arr1);

    }
}
