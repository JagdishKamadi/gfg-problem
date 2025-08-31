import java.util.Stack;

class Solution {
    static boolean isBalanced(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '[' || ch == '{' || ch == '(') {
                stack.push(ch);
            } else if (!stack.isEmpty()
                    && ((ch == ']' && stack.peek() == '[')
                    || (ch == '}' && stack.peek() == '{')
                    || (ch == ')' && stack.peek() == '('))) {
                stack.pop();
            } else {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
