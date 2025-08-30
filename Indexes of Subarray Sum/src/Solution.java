import java.util.ArrayList;

class Solution {
    static ArrayList<Integer> subarraySum(int[] arr, int target) {
        int left = 0;
        int sum = 0;
        ArrayList<Integer> lst = new ArrayList<>();
        for (int right = 0; right < arr.length; right++) {
            sum = sum + arr[right];

            while (sum > target) {
                sum = sum - arr[left++];
            }

            if (sum == target) {
                lst.add(left + 1);
                lst.add(right + 1);
                return lst;
            }
        }
        lst.add(-1);
        return lst;

    }
}
