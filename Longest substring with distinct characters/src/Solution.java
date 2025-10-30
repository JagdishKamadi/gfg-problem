import java.util.HashSet;
import java.util.Set;

class Solution {
    public int longestUniqueSubstr(String s) {
        Set<Character> set = new HashSet<>();
        int left = 0, maxSize = 0;

        for (int right = 0; right < s.length(); right++) {
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            maxSize = Math.max(maxSize, right - left + 1);
        }

        return maxSize;
    }
}
