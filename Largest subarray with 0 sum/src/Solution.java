import java.util.HashMap;
import java.util.Map;

class Solution {
    int maxLength(int arr[]) {
        int n = arr.length;
        Map<Integer, Integer> map = new HashMap<>();
        int maxLen = 0;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum += arr[i];

            if (sum == 0) {
                maxLen = i + 1;
            }

            Integer prevIIndex = map.get(sum);

            if (prevIIndex != null) {
                maxLen = Math.max(maxLen, i - prevIIndex);
            } else {
                map.put(sum, i);
            }
        }
        return maxLen;
    }
}