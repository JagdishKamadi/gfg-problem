
class Solution {
    public int maximumProfit(int prices[]) {
        int totalProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                totalProfit += prices[i] - prices[i - 1];
            }
        }
        return totalProfit;
    }

    public static void main(String[] args) {
        int[] prices = {4, 2, 2, 2, 4};
        System.out.println(new Solution().maximumProfit(prices));
    }
}