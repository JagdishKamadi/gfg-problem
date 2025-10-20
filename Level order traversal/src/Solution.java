import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public ArrayList<ArrayList<Integer>> levelOrder(Node root) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        getLevelOrderTraversal(root, ans);
        return ans;
    }

    public static void getLevelOrderTraversal(Node root, ArrayList<ArrayList<Integer>> ans) {
        Queue<Node> queue = new LinkedList<>();
        if (root != null) {
            queue.add(root);
            queue.add(null);
        }
        ArrayList<Integer> shortResult = new ArrayList<>();
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            if (current == null) {
                if (!queue.isEmpty()) {
                    ans.add(shortResult);
                    shortResult = new ArrayList<>();
                    queue.add(null);
                    continue;
                } else {
                    break;
                }
            }
            shortResult.add(current.data);
            if (current.left != null) {
                queue.add(current.left);
            }
            if (current.right != null) {
                queue.add(current.right);
            }
        }
        if (!shortResult.isEmpty()) { // Add this to capture the last level
            ans.add(shortResult);
        }
    }

    public static void main(String[] args) {
        int[] preOrder = {1, 2, -1, -1, 3, 4, -1, -1, 5, -1, -1};
        Node root = buildTree(preOrder, new int[]{-1});
        System.out.println(root);
        ArrayList<ArrayList<Integer>> arrayLists = new Solution().levelOrder(root);
        System.out.println(arrayLists);
    }

    private static Node buildTree(int[] arr, int[] index) {
        index[0]++;
        if (arr[index[0]] == -1 || index[0] >= arr.length) {
            return null;
        }

        Node root = new Node(arr[index[0]]);
        root.left = buildTree(arr, index);
        root.right = buildTree(arr, index);
        return root;
    }

    private static class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }
}