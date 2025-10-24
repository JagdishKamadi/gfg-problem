class Solution {
    public static boolean matSearch(int[][] mat, int x) {
        int n = mat.length;
        int j = mat[0].length - 1;
        int i = 0;
        while (i < n && j >= 0) {
            if (mat[i][j] == x) {
                return true;
            } else if (mat[i][j] > x) {
                j--; // move left
            } else {
                i++; // move right
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] mat = {{3, 30, 38}, {20, 52, 54}, {35, 60, 69}};
        int x = 62;
        System.out.println(Solution.matSearch(mat, x));
    }
}