import java.util.HashSet;
import java.util.Set;

class Solution {
    int longestUniqueSubstring(String s) {
        int maxLength = 0;
        Set<Character> set = new HashSet<>();
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left++));
            }
            set.add(s.charAt(right));
            maxLength = Math.max(maxLength, set.size());
        }
        return maxLength;
    }

    public static void main(String[] args) {
        String s = "geeksforgeeks";
        System.out.println(new Solution().longestUniqueSubstring(s));
    }
}