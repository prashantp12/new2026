package Practice;

import java.util.HashMap;
import java.util.Map;

public class FindTwoSum {

    static void main(String[] args) {
        int[] arr = {1, 3, 5, 7};
        int total = 6;

        Map<Integer, Integer> map1 = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int diff = total - arr[i];
            if (map1.containsKey(diff)) {
                System.out.println("indices are: " + map1.get(diff) + ", " + i);
                return;
            }
            map1.put(arr[i], i);
        }
        System.out.println("no pair found");
    }
}
