

import java.util.List;
import java.util.ArrayList;

class Solution {
    int getMiddle(Node head) {
        List<Integer> lst = new ArrayList<>();
        while (head != null) {
            lst.add(head.data);
            head = head.next;
        }
        System.out.println(lst);
        int size = lst.size();
        return lst.get(size / 2);
    }

    private static class Node {
        int data;
        Node next;

        Node(int x) {
            data = x;
            next = null;
        }
    }

    public static void main(String[] args) {
        int[] values = {1, 2, 3, 4, 5};
        Node head = new Node(values[0]);
        Node current = head;
        for (int i = 1; i < values.length; i++) {
            current.next = new Node(values[i]);
            current = current.next;
        }

        System.out.println("Result : " + new Solution().getMiddle(head));
    }
}