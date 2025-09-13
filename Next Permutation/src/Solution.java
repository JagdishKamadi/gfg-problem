import java.util.Arrays;

class Solution {
    void nextPermutation(int[] arr) {
        int n = arr.length;
        if (n <= 1) return;

        // 1. Find pivot (first index i where arr[i] < arr[i+1], scanning from right)
        int i = n - 2;
        while (i >= 0 && arr[i] >= arr[i + 1]) {
            i--;
        }

        // 2. If pivot exists
        if (i >= 0) {
            // find rightmost successor greater than pivot
            int j = n - 1;
            while (arr[j] <= arr[i]) {
                j--;
            }
            swap(arr, i, j);
        }

        // 3. Reverse suffix (part after pivot)
        reverse(arr, i + 1, n - 1);
    }

    private void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

    private void reverse(int[] arr, int left, int right) {
        while (left < right) {
            swap(arr, left++, right--);
        }
    }

    public static void main(String[] args) {
        int[] arr = {3, 4, 2, 5, 1};
        new Solution().nextPermutation(arr);
        System.out.println(Arrays.toString(arr)); // [3, 4, 5, 1, 2]
    }
}
