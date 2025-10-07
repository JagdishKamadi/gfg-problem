class Solution {

    static Boolean isSubsetSum(int arr[], int sum) {
        Boolean[][] dp = new Boolean[arr.length][sum + 1];
        return solve(arr, sum, 0, dp);
    }

    private static boolean solve(int[] arr, int sum, int i, Boolean[][] dp) {
        if (sum == 0)
            return true;
        if (i == arr.length)
            return false;

        if (dp[i][sum] != null)
            return dp[i][sum];

        boolean pick = false;
        if (arr[i] <= sum)
            pick = solve(arr, sum - arr[i], i + 1, dp);

        boolean noPick = solve(arr, sum, i + 1, dp);

        return dp[i][sum] = pick || noPick;
    }

    public static void main(String[] args) {
        int[] arr = {3, 34, 4, 12, 5, 2};
        int sum = 30;
        System.out.println(Solution.isSubsetSum(arr, sum));
    }
}
