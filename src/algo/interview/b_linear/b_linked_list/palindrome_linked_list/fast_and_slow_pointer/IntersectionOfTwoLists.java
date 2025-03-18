package algo.interview.b_linear.b_linked_list.palindrome_linked_list.fast_and_slow_pointer;

public class IntersectionOfTwoLists {

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null; // 왜 next까지 비교할 필요는 없을까?

        ListNode a = headA, b = headB;

        while (a != b) {
            a = (a == null) ? headB : a.next;
            b = (b == null) ? headA : b.next;
        }

        return a; // 교차점 반환 (없으면 null 리턴)
    }

    public static void main(String[] args) {

        ListNode acyclicLinkedListHead = new ListNode(1);
        acyclicLinkedListHead.next = new ListNode(2);
        acyclicLinkedListHead.next.next = new ListNode(3);
        acyclicLinkedListHead.next.next.next = new ListNode(4);
        acyclicLinkedListHead.next.next.next.next = new ListNode(5);

        ListNode cyclicLinkedListHead = new ListNode(1);
        cyclicLinkedListHead.next = new ListNode(2);
        ListNode cycleStart = new ListNode(3);
        cyclicLinkedListHead.next.next = cycleStart; // 사이클 시작점
        cyclicLinkedListHead.next.next.next = new ListNode(4);
        cyclicLinkedListHead.next.next.next.next = new ListNode(5);
        cyclicLinkedListHead.next.next.next.next.next = cycleStart;

        ListNode intersectionNode = getIntersectionNode(acyclicLinkedListHead, cyclicLinkedListHead);
        System.out.println(intersectionNode.val);
    }
}

/** [내용]
 * 1. 포인터 a는 headA에서 시작, 포인터 b는 headB에서 시작
 * 2. 한 리스트의 끝에 도달하면, 반대 리스트의 헤드로 이동
 * 3. 결국 같은 노드에서 만나거나, 둘 다 null에서 종료
 */