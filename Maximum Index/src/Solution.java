class Solution {
    int maxIndexDiff(int[] arr) {
        // code here
        int diff = 0;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] < arr[j] && (j - i) > diff) {
                    diff = j - i;
                }
            }
        }
        return diff;
    }

    public static void main(String[] args) {
        int[] arr = {34, 8, 10, 3, 2, 80, 30, 33, 1};
        System.out.println(new Solution().maxIndexDiff(arr));
    }
}