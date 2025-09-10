class Solution {
    public int findMin(int n) {
        int count = 0;

        count += n / 10;
        n %= 10;

        count += n / 5;
        n %= 5;

        count += n / 2;
        n %= 2;

        count += n; // if n == 1, add 1, else add 0

        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findMin(39)); // Output: 6
    }
}
