import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        int[] values = new int[]{1, 2, 3, 4, 5};
        Node head = new Node(values[0]);
        Node current = head;

        for (int i = 1; i < values.length; i++) {
            current.next = new Node(values[i]);
            current = current.next;
        }

        Node rootNode = new Solution().reverseList(head);
        showList(rootNode);

        System.out.println();
        Node rootNode2 = new Solution().reverseList1(head);
        showList(rootNode2);
    }

    // solution 1
    Node reverseList(Node head) {
        List<Integer> lst = new ArrayList<>();
        while (head != null) {
            lst.add(head.data);
            head = head.next;
        }
        int size = lst.size() - 1;
        head = new Node(lst.get(size));
        Node currentNode = head;

        for (int i = size - 1; i >= 0; i--) {
            currentNode.next = new Node(lst.get(i));
            currentNode = currentNode.next;
        }
        return head;
    }

    // solution 2
    Node reverseList1(Node head) {
        Node prev = null;
        Node current = head;

        while (current != null) {
            Node nextNode = current.next; // to save the data
            current.next = prev;
            prev = current;
            current = nextNode;
        }

        return prev;
    }

    private static void showList(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }

    private static class Node {
        public int data;
        public Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
}
