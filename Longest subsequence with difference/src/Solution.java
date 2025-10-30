import java.util.Arrays;

class Solution {
    public int maxLenSub(int[] arr) {
        Arrays.sort(arr);
        int maxLen = 0;
        int count = 1;

        for (int i = 1; i < arr.length; i++) {
            int diff = arr[i] - arr[i - 1];
            if (diff == 0 || diff == 1) {
                count++;
            } else {
                count = 1;
            }
            maxLen = Math.max(maxLen, count);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        int[] arr = {2, 5, 6, 3, 7, 6, 5, 8};
        System.out.println(new Solution().maxLenSub(arr));
    }
}