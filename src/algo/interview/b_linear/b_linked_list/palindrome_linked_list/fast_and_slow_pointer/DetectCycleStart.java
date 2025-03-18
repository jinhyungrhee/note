package algo.interview.b_linear.b_linked_list.palindrome_linked_list.fast_and_slow_pointer;

public class DetectCycleStart {

    public static ListNode detectCycleStart(ListNode head) {

        if (head == null || head.next == null) return null;
        
        ListNode fast = head, slow = head;
        
        // 사이클 있는지 확인
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            // 사이클 존재 (이때는 fast와 slow가 내부의 임의의 지점에서 만남)
            if (fast == slow) {
                slow = head; // slow를 다시 head로 이동 (-> fast는 그대로 둠)

                // 이후로 fast와 slow를 한칸씩 이동시키면서 다시 만나게 되는 지점이 바로
                // 사이클 시작점임! (어떻게?)
                while (fast != slow) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow; // 사이클 시작점 노드
            }
        }
        return null; // 사이클 없음
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

        ListNode result1 = detectCycleStart(acyclicLinkedListHead);
        System.out.println(result1 == null ? null : result1.val);

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

        ListNode result2 = detectCycleStart(cyclicLinkedListHead);
        System.out.println(result2 == null ? null : result2.val);
    }
}
