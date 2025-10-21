import java.util.Arrays;

class Solution {
    private static int count = 0;

    static int inversionCount(int[] arr) {
        count = 0;
        new Solution().sortArr(arr, 0, arr.length - 1);
        return count;
    }

    private void sortArr(int[] arr, int start, int end) {
        if (start < end) {
            int mid = start + (end - start) / 2;
            sortArr(arr, start, mid);
            sortArr(arr, mid + 1, end);
            mergeArr(arr, start, mid, end);
        }
    }

    private void mergeArr(int[] arr, int start, int mid, int end) {
        int n1 = mid - start + 1;
        int n2 = end - mid;
        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];

        for (int i = 0; i < n1; i++) {
            leftArr[i] = arr[start + i];
        }

        for (int i = 0; i < n2; i++) {
            rightArr[i] = arr[mid + 1 + i];
        }

        int i1 = 0, i2 = 0;
        int c = start;

        while (i1 < n1 && i2 < n2) {
            if (leftArr[i1] <= rightArr[i2]) {
                arr[c++] = leftArr[i1++];
            } else {
                count += (n1 - i1);
                arr[c++] = rightArr[i2++];
            }
        }

        while (i1 < n1) {
            arr[c++] = leftArr[i1++];
        }

        while (i2 < n2) {
            arr[c++] = rightArr[i2++];
        }
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 5, 6};
        int count = inversionCount(arr);
        System.out.println(count);
    }
}