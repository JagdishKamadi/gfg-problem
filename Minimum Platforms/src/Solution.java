import java.util.Arrays;

class Solution {
    public int minPlatform(int arr[], int dep[]) {
        Arrays.sort(arr);
        Arrays.sort(dep);
        int i = 0, j = 0, n = arr.length;
        int max = Integer.MIN_VALUE;
        int count = 0;
        while (i < n && j < n) {
            if (arr[i] <= dep[j]) {
                count++;
                i++;
            } else {
                count--;
                j++;
            }
            if (count > max)
                max = count;
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {1000, 935, 1100}, dep = {1200, 1240, 1130};
        System.out.println(new Solution().minPlatform(arr, dep));
    }
}
