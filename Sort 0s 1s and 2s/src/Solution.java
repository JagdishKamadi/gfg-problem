import java.util.Arrays;

class Solution {
    public void sort012(int[] arr) {
        mergeSort(arr, 0, arr.length - 1);
    }

    private static void mergeSort(int[] arr, int start, int end) {
        if (start < end) {
            int mid = start + (end - start) / 2;
            mergeSort(arr, start, mid);
            mergeSort(arr, mid + 1, end);
            // merge the two array now
            mergeArr(arr, start, mid, end);
        }
    }

    private static void mergeArr(int[] arr, int start, int mid, int end) {
        int n1 = mid - start + 1;
        int n2 = end - mid;
        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++) {
            L[i] = arr[start + i];
        }

        for (int j = 0; j < n2; j++) {
            R[j] = arr[mid + 1 + j];
        }

        int i1 = 0;
        int i2 = 0;
        int c = start;

        while (i1 < n1 && i2 < n2) {
            if (L[i1] <= R[i2]) {
                arr[c++] = L[i1++];
            } else {
                arr[c++] = R[i2++];
            }
        }

        while (i1 < n1) {
            arr[c++] = L[i1++];
        }

        while (i2 < n2) {
            arr[c++] = R[i2++];
        }
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1};
        new Solution().sort012(arr);
        System.out.println(Arrays.toString(arr));
    }
}