import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class GFGSolution {
    public ArrayList<Integer> maxOfSubarrays(int[] arr, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        Deque<Integer> dq = new LinkedList<>();

        int i;
        for (i = 0; i < k; ++i) {
            while (!dq.isEmpty() && arr[i] >= arr[dq.peekLast()])
                dq.removeLast();
            dq.addLast(i);
        }

        for (; i < arr.length; ++i) {
            result.add(arr[dq.peekFirst()]);
            while (!dq.isEmpty() && dq.peekFirst() <= i - k)
                dq.removeFirst();
            while (!dq.isEmpty() && arr[i] >= arr[dq.peekLast()])
                dq.removeLast();
            dq.addLast(i);
        }

        result.add(arr[dq.peekFirst()]);
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {2, 19, 15, 5, 35, 14, 12, 18};
        int k = 8;
        System.out.println(new BruteForceSolution().maxOfSubarrays(arr, k));
    }
}
