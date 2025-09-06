import java.util.Arrays;

class Solution {
    int countTriplet(int arr[]) {
        int n = arr.length;
        int count = 0;
        Arrays.sort(arr);
        for (int i = n - 1; i >= 2; i--) {
            long c = arr[i];
            int left = 0, right = i - 1;
            while (left < right) {
                long sum = (long) arr[left] + arr[right];
                if (sum == c) {
                    count++;
                    left++;
                    right--;
                } else if (sum < c) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 4};
        System.out.println(new Solution().countTriplet(nums));
    }
}