import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> camelCase(String[] arr, String pat) {
        List<String> result = new ArrayList<>();
        for (String word : arr) {
            StringBuilder caps = new StringBuilder();
            for (char ch : word.toCharArray()) {
                if (Character.isUpperCase(ch)) caps.append(ch);
            }
            if (caps.toString().startsWith(pat)) {
                result.add(word);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String[] arr = {"Hi", "Hello", "HelloWorld", "HiTech", "HiGeek", "HiTechWorld", "HiTechCity", "HiTechLab"};
        String pat = "HA";
        System.out.println(new Solution().camelCase(arr, pat));
    }
}
