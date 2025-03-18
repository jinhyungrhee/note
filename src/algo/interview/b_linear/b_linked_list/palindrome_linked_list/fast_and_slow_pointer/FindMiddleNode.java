package algo.interview.b_linear.b_linked_list.palindrome_linked_list.fast_and_slow_pointer;

public class FindMiddleNode {

    public static ListNode findMiddleNode(ListNode head) {
        if (head == null || head.next == null) return null;

        ListNode fast = head, slow = head;

        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow; // 중간 노드 반환
    }


    public static void main(String[] args) {
        /**
         * CASE1 : 사이클이 없는 링크드 리스트 (1 -> 2 -> 3 -> 4 -> 5 -> null)
         */
        ListNode acyclicLinkedListHead = new ListNode(1);
        acyclicLinkedListHead.next = new ListNode(2);
        acyclicLinkedListHead.next.next = new ListNode(3);
        acyclicLinkedListHead.next.next.next = new ListNode(4); // 중간노드
        acyclicLinkedListHead.next.next.next.next = new ListNode(5);
        acyclicLinkedListHead.next.next.next.next.next = new ListNode(6);

        if (!FloydsCycleDetectionAlgorithm.hasCycle(acyclicLinkedListHead)) {
            ListNode result1 = findMiddleNode(acyclicLinkedListHead);
            System.out.println(result1 == null ? null : result1.val);
        } else {
            System.out.println("Cycle Detected. Terminate the program.");
        }

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

        if (!FloydsCycleDetectionAlgorithm.hasCycle(cyclicLinkedListHead)) {
            ListNode result2 = findMiddleNode(cyclicLinkedListHead);
            System.out.println(result2 == null ? null : result2.val);
        } else {
            System.out.println("Cycle Detected. Terminate the program.");
        }
    }
}
