

class Solution {
    public int SumofMiddleElements(int[] arr1, int[] arr2) {
        int n = arr1.length;
        int[] arr = new int[n * 2];
        int c = 0;
        int c1 = 0;
        int c2 = 0;

        while (c1 < n && c2 < n) {
            if (arr1[c1] <= arr2[c2]) {
                arr[c++] = arr1[c1++];
            } else {
                arr[c++] = arr2[c2++];
            }
        }
        while (c1 < n) {
            arr[c++] = arr1[c1++];
        }

        while (c2 < n) {
            arr[c++] = arr2[c2++];
        }

        return arr[n] + arr[n - 1];
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 12, 15, 26, 38};
        int[] arr2 = {2, 13, 17, 30, 45};

        System.out.println(new Solution().SumofMiddleElements(arr1, arr2));
    }
}