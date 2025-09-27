import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

class pair {
    long first, second;

    public pair(long first, long second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public String toString() {
        return "pair{" +
                "first=" + first +
                ", second=" + second +
                '}';
    }
}

class Solution {
    public pair[] allPairs(int target, int arr1[], int arr2[]) {
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<pair> p = new ArrayList<>();
        for (int i = 0; i < arr2.length; i++) {
            map.put(arr2[i], map.getOrDefault(arr2[i], 0) + 1);
        }
        for (int i = 0; i < arr1.length; i++) {
            int a = arr1[i];
            int b = target - a;
            if (map.containsKey(b) && map.get(b) > 1) {
                for (int k = 0; k < map.get(b); k++) {
                    p.add(new pair(a, b));
                }
            } else if (map.containsKey(b)) {
                p.add(new pair(a, b));
            }
        }
        return p.toArray(new pair[0]);
    }

    public static void main(String[] args) {
        int target = 9;
        int[] a = {1, 2, 4, 5, 7, 4}, b = {5, 6, 3, 4, 8, 4};

        for (pair p : new Solution().allPairs(target, a, b)) {
            System.out.println(p.first + " | " + p.second);
        }
    }
}