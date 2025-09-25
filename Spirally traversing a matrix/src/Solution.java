import java.util.ArrayList;

class Solution {
    public ArrayList<Integer> spirallyTraverse(int[][] mat) {
        ArrayList<Integer> result = new ArrayList<>();
        int n = mat.length;
        int m = mat[0].length;
        int d = 0;
        int top = 0, down = n - 1, left = 0, right = m - 1;

        while (left <= right && top <= down) {
            if (d == 0) {
                // left to right
                for (int i = left; i <= right; i++) {
                    result.add(mat[top][i]);
                }
                top++;
            } else if (d == 1) {
                // top to down
                for (int i = top; i <= down; i++) {
                    result.add(mat[i][right]);
                }
                right--;
            } else if (d == 2) {
                // right to left
                for (int i = right; i >= left; i--) {
                    result.add(mat[down][i]);
                }
                down--;
            } else if (d == 3) {
                // down to top
                for (int i = down; i >= top; i--) {
                    result.add(mat[i][left]);
                }
                left++;
            }
            d = (d + 1) % 4;
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] mat = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        System.out.println(new Solution().spirallyTraverse(mat));
    }
}
