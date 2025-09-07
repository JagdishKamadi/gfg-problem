import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfTestCases = scanner.nextInt();
        while (numberOfTestCases-- > 0) {
            int sizeOfArray = scanner.nextInt();
            int[] nums = new int[sizeOfArray];
            for (int j = 0; j < sizeOfArray; j++) {
                nums[j] = scanner.nextInt();
            }
            sortBasedOnFrequencies(nums);
        }
    }

    private static void sortBasedOnFrequencies(int[] nums) {
        Map<Integer, Long> collect = Arrays.stream(nums)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        List<Map.Entry<Integer, Long>> entries = new ArrayList<>(collect.entrySet());
        entries.sort(ENTRY_COMPARATOR);
        int count = 0;
        for (Map.Entry<Integer, Long> entry : entries) {
            for (int i = 0; i < entry.getValue(); i++) {
                nums[count++] = entry.getKey();
            }
        }

        for (int i = 0; i < nums.length - 1; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println(nums[nums.length - 1]);
    }


    private static final Comparator<Map.Entry<Integer, Long>> ENTRY_COMPARATOR = (e1, e2) -> {
        if (Objects.equals(e1.getValue(), e2.getValue())) {
            return e1.getKey().compareTo(e2.getKey());
        }
        return e2.getValue().compareTo(e1.getValue());
    };
}
