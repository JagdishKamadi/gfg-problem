import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    public static String reverseWords(String s) {
        List<String> list = Arrays.stream(s.split("\\.+"))
                .filter(w -> !w.isEmpty())
                .collect(Collectors.toList());
        Collections.reverse(list);
        return String.join(".", list);
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("i.like.this.program.very.much"));
        // Output: "much.very.program.this.like.i"

        System.out.println(reverseWords("..geeks..for.geeks."));
        // Output: "geeks.for.geeks"

        System.out.println(reverseWords("..home....."));
        // Output: "home"
    }
}


