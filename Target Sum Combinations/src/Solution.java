import java.util.ArrayList;

class Solution {
    public ArrayList<ArrayList<Integer>> targetSumComb(int[] arr, int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        generateSumComb(arr, target, new ArrayList<>(), 0, result);
        return result;
    }

    private void generateSumComb(int[] arr, int target, ArrayList<Integer> ans, int index, ArrayList<ArrayList<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(ans));
            return;
        }

        if (index == arr.length || target < 0) {
            return;
        }

        // Include current element (can reuse same element)
        ans.add(arr[index]);
        generateSumComb(arr, target - arr[index], ans, index, result);

        // Exclude current element and move to next
        ans.remove(ans.size() - 1);
        generateSumComb(arr, target, ans, index + 1, result);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        int target = 5;

        System.out.println(new Solution().targetSumComb(arr, target));
    }
}
