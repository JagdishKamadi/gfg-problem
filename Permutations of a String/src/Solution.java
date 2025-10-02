import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public ArrayList<String> findPermutation(String s) {
        Set<String> set = new HashSet<>();
        genPerm(s, "", set);
        return new ArrayList<>(set);
    }


    private static void genPerm(String str, String res, Set<String> set) {
        if (str.isEmpty()) {
            set.add(res);
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            String leftPart = str.substring(0, i);
            String rightPart = str.substring(i + 1);
            String fullPart = leftPart + rightPart;
            genPerm(fullPart, res + str.charAt(i), set);
        }
    }

    public static void main(String[] args) {
        String str = "ABCC";
        System.out.println(new Solution().findPermutation(str));
    }
}