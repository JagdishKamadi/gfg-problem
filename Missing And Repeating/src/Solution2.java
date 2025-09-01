import java.util.ArrayList;

class Solution2 {
    ArrayList<Integer> findTwoElement(int arr[]) {
        // code here
        int n = arr.length;
        int[] freq = new int[n + 1];

        for (int i : arr) {
            freq[i] = freq[i] + 1;
        }
        int repeating = -1;
        int missing = -1;

        // identify missing and repeating numbers
        for (int i = 1; i <= n; i++) {
            if (freq[i] == 0) missing = i;
            else if (freq[i] == 2) repeating = i;
        }

        ArrayList<Integer> lst = new ArrayList<>();
        lst.add(repeating);
        lst.add(missing);
        return lst;
    }
}
