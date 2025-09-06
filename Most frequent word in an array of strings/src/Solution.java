import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {

    public String mostFrequentWord(String[] arr, int n) {
        Map<String, Integer> freq = new HashMap<>();
        int max = 0;

        // Count frequencies & track max frequency
        for (String str : arr) {
            int count = freq.getOrDefault(str, 0) + 1;
            freq.put(str, count);
            max = Math.max(max, count);
        }

        String result = "";
        Set<String> set = new HashSet<>();
        // Traverse left-to-right → last valid candidate will win
        for (int i = 0; i < n; i++) {
            String key = arr[i];
            if (freq.get(key) == max && !set.contains(key)) {
                result = key;
                set.add(key);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        String[] arr = {"xejdcj", "xejdcj", "lvjpb", "tmyuiu", "lvjpb", "tmyuiu",
                "ovoba", "lvjpb", "lvjpb", "fqhyu", "fqhyu", "tmyuiu",
                "xejdcj", "tmyuiu", "fqhyu", "ovoba", "xejdcj"};
        String result = new Solution().mostFrequentWord(arr, arr.length);
        System.out.println(result); // Output: tmyuiu
    }
}
