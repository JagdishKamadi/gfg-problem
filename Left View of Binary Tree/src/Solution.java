import java.util.ArrayList;

public class Solution {

    public static void main(String[] args) {
        //root[] = [1, 2, 3, 4, 5, N, N]
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        System.out.println(new Solution().leftView(root));
    }

    ArrayList<Integer> leftView(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        leftViewHelper(root, result, 0);
        return result;
    }

    private void leftViewHelper(Node node, ArrayList<Integer> result, int level) {
        if (node == null) return;
        if (level == result.size()) result.add(node.data); // first node at this level
        leftViewHelper(node.left, result, level + 1);
        leftViewHelper(node.right, result, level + 1);
    }

    private static class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
    }
}
