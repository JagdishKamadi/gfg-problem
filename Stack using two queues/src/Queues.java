import java.util.LinkedList;
import java.util.Queue;

class Queues {
    Queue<Integer> q1 = new LinkedList<Integer>();
    Queue<Integer> q2 = new LinkedList<Integer>();

    void push(int a) {
        q1.offer(a);
    }

    int pop() {
        if (q1.isEmpty()) {
            return -1;
        }
        while (q1.size() > 1) {
            q2.offer(q1.poll());
        }
        int lastElement = q1.poll();
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
        return lastElement;
    }
}