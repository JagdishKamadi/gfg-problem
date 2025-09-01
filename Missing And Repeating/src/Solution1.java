import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

class Solution1 {
    ArrayList<Integer> findTwoElement(int arr[]) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        ArrayList<Integer> lst = new ArrayList<>();
        int repeating = -1;
        int missing = -1;
        int count = 1;

        for (int i : arr) {
            if (map.containsKey(i) && map.get(i) == 2) {
                repeating = i;
            }
            if (!map.containsKey(count)) {
                missing = count;
            }
            count++;
        }
        lst.add(repeating);
        lst.add(missing);

        return lst;
    }
}
