import java.util.ArrayList;

class BruteForceSolution {
    public ArrayList<Integer> maxOfSubarrays(int[] arr, int k) {
        ArrayList<Integer> lst = new ArrayList<>();
        int n = arr.length;
        if (n == 1) {
            lst.add(arr[0]);
            return lst;
        }
        for (int i = 0; i <= (n - k); i++) {
            int max = 0;
            for (int j = i; j < (i + k); j++) {
                if (arr[j] > max) {
                    max = arr[j];
                }
            }
            lst.add(max);
        }
        return lst;
    }

    public static void main(String[] args) {
        int[] arr = {2, 19, 15, 5, 35, 14, 12, 18};
        int k = 8;
        System.out.println(new BruteForceSolution().maxOfSubarrays(arr, k));
    }
}