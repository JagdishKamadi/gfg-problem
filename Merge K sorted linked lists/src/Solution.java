import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}

class Solution {
    Node mergeKLists(Node[] arr) {
        List<Integer> nums = new ArrayList<>();

        for (Node node : arr) {
            while (node != null) {
                nums.add(node.data);
                node = node.next;
            }
        }
        Collections.sort(nums);
        Node head = new Node(nums.getFirst());
        Node current = head;

        for (int i = 1; i < nums.size(); i++) {
            current.next = new Node(nums.get(i));
            current = current.next;
        }
        return head;
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{1, 3, 7};
        int[] arr2 = new int[]{2, 4, 8};
        int[] arr3 = new int[]{9};
        Node[] nodes = new Node[3];
        nodes[0] = getHead(arr1);
        nodes[1] = getHead(arr2);
        nodes[2] = getHead(arr3);

        Node head = new Solution().mergeKLists(nodes);
        printLinkedList(head);
    }

    private static Node getHead(int[] arr) {
        Node head = new Node(arr[0]);
        Node current = head;

        for (int i = 1; i < arr.length; i++) {
            current.next = new Node(arr[i]);
            current = current.next;
        }
        return head;
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