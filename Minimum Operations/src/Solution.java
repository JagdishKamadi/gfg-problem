public class Solution {

    public static void main(String[] args) {
        int n = 96234;
        System.out.println(new Solution().minOperation(n));
    }

    public int minOperation(int n) {
        // Base case
        if (n == 0) return 0;

        // If n is even, previous step must be doubling
        if (n % 2 == 0) {
            return 1 + minOperation(n / 2);
        } else {
            // If n is odd, previous step must be n - 1
            return 1 + minOperation(n - 1);
        }
    }
}
