import java.util.*;

public class Solution {
    public static void main(String[] args) {
        int[] a1 = {4, 1, 3, 3, 2};
        int[] a2 = {3, 1};

        // output
        //[3, 3, 1, 2, 4]

        relativeSort(a1, a2);
        System.out.println(Arrays.toString(a1));
    }

    static void relativeSort(int[] a1, int[] a2) {
        Map<Integer, Integer> map = new TreeMap<>();

        for (int i : a1) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        // now add the first appearing element
        int count = 0;
        for (int i : a2) {
            if (map.containsKey(i)) {
                for (int j = 0; j < map.get(i); j++) {
                    a1[count++] = i;
                }
                map.remove(i);
            }
        }

        // now stored the element which is not appearing in the second array
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            for (int i = 0; i < entry.getValue(); i++) {
                a1[count++] = entry.getKey();
            }
        }
    }
}
