package algo.interview.zz_concept.queue;

import java.util.Stack;

public class TwoStackQueue<T> {
    private Stack<T> inStack;
    private Stack<T> outStack;

    public TwoStackQueue() {
        inStack = new Stack<>();
        outStack = new Stack<>();
    }

    public void enqueue(T x) {
        inStack.push(x);
    }

    public T dequeue() {
        shiftStacks();
        if (outStack.isEmpty()) {
            throw new RuntimeException("Queue is Empty!");
        }
        return outStack.pop();
    }

    public T peek() {
        shiftStacks();
        if (outStack.isEmpty()) {
            throw new RuntimeException("Queue is Empty!");
        }
        return outStack.peek();
    }

    public boolean isEmpty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }

    private void shiftStacks() {
        if (outStack.isEmpty()) {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
    }

    /** shiftStacks
     *  - outStack이 비었을 때만, inStack에서 모든 데이터를 옮겨서 효율을 높임
     *  - amortized O(1)
     */

}
