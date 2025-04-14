package algo.interview.zz_concept.queue;

public class TwoStackQueueMain {
    public static void main(String[] args) {
        TwoStackQueue<Integer> queue = new TwoStackQueue<>();

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        System.out.println(queue.peek());    // 1
        System.out.println(queue.dequeue()); // 1
        System.out.println(queue.peek());    // 2
        System.out.println(queue.dequeue()); // 2
        System.out.println(queue.isEmpty()); // false
        System.out.println(queue.peek());    // 3
        System.out.println(queue.dequeue()); // 3
        System.out.println(queue.isEmpty()); // true
        System.out.println(queue.peek());    // RuntimeException: Queue is Empty!

    }
}
