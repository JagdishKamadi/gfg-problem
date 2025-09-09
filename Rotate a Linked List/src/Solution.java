public class Solution {
    public Node rotate(Node head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }
        Node lastNode = head;
        int n = 1;
        while (lastNode.next != null) {
            n++;
            lastNode = lastNode.next;
        }
        k = k % n;
        if (k == 0) {
            return head;
        }
        Node curr = head;
        for (int i = 1; i < k; i++) {
            curr = curr.next;
        }
        Node newHead = curr.next;
        curr.next = null;
        lastNode.next = head;
        return newHead;
    }

    public static void printList(Node head) {
        System.out.print("[ ");

        while (head.next != null) {
            System.out.print(head.data + ", ");
            head = head.next;
        }
        System.out.println(head.data + " ]");
    }

    public static void main(String[] args) {
        int[] values = new int[]{10, 20, 30, 40, 50};
        Node head = new Node(values[0]);
        Node current = head;

        for (int i = 1; i < values.length; i++) {
            current.next = new Node(values[i]);
            current = current.next;
        }

        printList(head);
        Node newHead = new Solution().rotate(head, 4);
        printList(newHead);
    }
}
