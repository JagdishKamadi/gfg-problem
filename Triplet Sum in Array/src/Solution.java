import java.util.Arrays;

class Solution {
    public boolean hasTripletSum(int[] arr, int target) {
        // first step is to sort the array
        Arrays.sort(arr);
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int start = i + 1;
            int end = n - 1;

            while (start < end) {
                if ((arr[i] + arr[start] + arr[end]) == target) {
                    return true;
                } else if ((arr[i] + arr[start] + arr[end]) < target) {
                    start++;
                } else {
                    end--;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {40, 20, 10, 3, 6, 7};
        int target = 24;
        System.out.println(new Solution().hasTripletSum(arr, target));
    }
}
