public class Solution {
    int maxSubarraySum(int[] arr) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int i : arr) {
            sum += i;
            max = Math.max(max, sum);
            if (sum < 0) {
                sum = 0;
            }
        }
        return max;
    }
}
