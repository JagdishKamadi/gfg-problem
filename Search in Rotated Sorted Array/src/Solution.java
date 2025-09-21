class Solution {
    public static void main(String[] args) {
        int[] arr = {12, 13, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        int key = 3;
        System.out.println(new Solution().search(arr, key));
    }

    int search(int[] arr, int key) {
        int pivot = getPivotIndex(arr);

        if (pivot != -1) {
            if (arr[0] <= key && arr[pivot] >= key) {
                return getKey(key, arr, 0, pivot);
            }
            if (arr[pivot + 1] <= key && key <= arr[arr.length - 1]) {
                return getKey(key, arr, pivot + 1, arr.length - 1);
            }
            return -1;
        } else {
            return getKey(key, arr, 0, arr.length - 1);
        }
    }

    private static int getKey(int key, int[] arr, int start, int end) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == key) {
                return mid;
            } else if (arr[mid] < key) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }

    private static int getPivotIndex(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] > arr[i]) {
                return i - 1;
            }
        }
        return -1;
    }
}
