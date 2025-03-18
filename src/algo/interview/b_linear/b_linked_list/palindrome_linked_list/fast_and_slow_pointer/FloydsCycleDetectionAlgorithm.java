package algo.interview.b_linear.b_linked_list.palindrome_linked_list.fast_and_slow_pointer;

public class FloydsCycleDetectionAlgorithm {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    // Floyd's Cycle Detection Algorithm
    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;

        ListNode fast = head, slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) return true;
        }

        return false;
    }

    public static void main(String[] args) {

        /**
         * CASE1 : 사이클이 없는 링크드 리스트 (1 -> 2 -> 3 -> 4 -> 5 -> null)
         */
        ListNode acyclicLinkedListHead = new ListNode(1);
        acyclicLinkedListHead.next = new ListNode(2);
        acyclicLinkedListHead.next.next = new ListNode(3);
        acyclicLinkedListHead.next.next.next = new ListNode(4);
        acyclicLinkedListHead.next.next.next.next = new ListNode(5);

        boolean result1 = hasCycle(acyclicLinkedListHead);
        System.out.println(result1);

        /**
         * CASE2 : 사이클이 있는 링크드 리스트 (1 -> 2 -> 3 -> 4- > 5 -> 3 -> 4 -> ... -> )
         */
        ListNode cyclicLinkedListHead = new ListNode(1);
        cyclicLinkedListHead.next = new ListNode(2);
        ListNode cycleStart = new ListNode(3);
        cyclicLinkedListHead.next.next = cycleStart; // 사이클 시작점
        cyclicLinkedListHead.next.next.next = new ListNode(4);
        cyclicLinkedListHead.next.next.next.next = new ListNode(5);
        cyclicLinkedListHead.next.next.next.next.next = cycleStart; // 사이클 형성 (5 -> 3)

        boolean result2 = hasCycle(cyclicLinkedListHead);
        System.out.println(result2);


    }
}
