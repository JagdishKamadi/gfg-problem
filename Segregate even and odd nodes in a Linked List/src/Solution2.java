public class Solution2 {
    Node divide(Node head) {
        if (head == null) {
            return null;
        }
        Node evenHead = null, evenTail = null;
        Node oddHead = null, oddTail = null;
        Node curr = head;
        while (curr != null) {
            if (curr.data % 2 == 0) {
                if (evenHead == null) {
                    evenHead = evenTail = curr;
                } else {
                    evenTail.next = curr;
                    evenTail = curr;
                }
            } else {
                if (oddHead == null) {
                    oddHead = oddTail = curr;
                } else {
                    oddTail.next = curr;
                    oddTail = curr;
                }
            }
            curr = curr.next;
        }
        if (evenHead == null) {
            return oddHead;
        }
        if (oddTail != null) {
            oddTail.next = null;
        }

        evenTail.next = oddHead;
        return evenHead;
    }
}
