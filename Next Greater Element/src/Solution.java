import java.util.*;

public class Solution {
    public ArrayList<Integer> nextLargerElement(int[] arr) {
        int n = arr.length;
        ArrayList<Integer> result = new ArrayList<>(Collections.nCopies(n, -1));
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] <= arr[i]) {
                stack.pop();
            }

            if (!stack.isEmpty()) {
                result.set(i, arr[stack.peek()]);
            }

            stack.push(i);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {6, 8, 0, 1, 3};

        System.out.println(new Solution().nextLargerElement(arr));
    }
}
