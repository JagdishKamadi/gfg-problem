import java.util.ArrayList;
import java.util.List;

class Solution {
    Node divide(Node head) {
        List<Integer> evenNumbersList = new ArrayList<>();
        List<Integer> oddNumbersList = new ArrayList<>();

        while (head != null) {
            if (head.data % 2 == 0) {
                evenNumbersList.add(head.data);
            } else {
                oddNumbersList.add(head.data);
            }
            head = head.next;
        }

        Node newHead = new Node(evenNumbersList.getFirst());
        Node current = newHead;
        for (int i = 1; i < evenNumbersList.size(); i++) {
            current.next = new Node(evenNumbersList.get(i));
            current = current.next;
        }

        for (int i = 0; i < oddNumbersList.size(); i++) {
            current.next = new Node(oddNumbersList.get(i));
            current = current.next;
        }

        return newHead;
    }

    public static void main(String[] args) {
        int[] arr = {17, 15, 8, 9, 2, 4, 6};
        Node head = buildLL(arr);
        printLL(head);
        System.out.println("After");
        printLL(new Solution().divide(head));
    }

    private static Node buildLL(int[] arr) {
        Node head = new Node(arr[0]);
        Node current = head;
        for (int i = 1; i < arr.length; i++) {
            current.next = new Node(arr[i]);
            current = current.next;
        }
        return head;
    }

    private static void printLL(Node head) {
        System.out.print("[");

        while (head.next != null) {
            System.out.print(head.data + ", ");
            head = head.next;
        }
        System.out.println(head.data + "]");
    }
}