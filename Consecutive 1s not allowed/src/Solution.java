// User function Template for Java

class Solution {

    // this can done using the simple fibonacci problem code
    int countStrings(int n) {
        if (n == 0) return 1;  // Fib(2)
        if (n == 1) return 2;  // Fib(3)

        int a = 1; // Fib(2)
        int b = 2; // Fib(3)

        for (int i = 2; i <= n; i++) {
            int c = a + b;
            a = b;
            b = c;
        }
        return b;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().countStrings(1));
    }
}