class Solution {
    public int peakElement(int[] arr) {
        int res = 0;
        int n = arr.length;

        for (int i = 1; i < n; i++) {
            if (arr[i - 1] < arr[i])
                res = i;
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        System.out.println(new Solution().peakElement(arr) == -1 ? "False" : "True");
    }
}