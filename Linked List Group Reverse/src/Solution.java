import java.util.ArrayList;
import java.util.List;

class Node {
    int data;
    Node next;

    Node(int key) {
        data = key;
        next = null;
    }
}

class Solution {
    public Node reverseKGroup(Node head, int k) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.data);
            head = head.next;
        }

        Node dummy = new Node(0);
        Node current = dummy;
        int size = list.size();

        int i = 0;
        while (i + k <= size) {
            for (int j = k - 1; j >= 0; j--) {
                current.next = new Node(list.get(i + j));
                current = current.next;
            }
            i += k;
        }

        int remainElementSize = size - i;
        while (remainElementSize-- > 0) {
            current.next = new Node(list.get(i + remainElementSize));
            current = current.next;
        }


        return dummy.next;
    }


    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6};
        Node head = new Node(arr[0]);
        Node current = head;

        for (int i = 1; i < arr.length; i++) {
            current.next = new Node(arr[i]);
            current = current.next;
        }
        printLinkedList(head);
        Node newHead = new Solution().reverseKGroup(head, 4);
        printLinkedList(newHead);
    }

    private static void printLinkedList(Node head) {
        System.out.print("[");
        while (head.next != null) {
            System.out.print(head.data + ", ");
            head = head.next;
        }
        System.out.println(head.data + "]");
    }
}