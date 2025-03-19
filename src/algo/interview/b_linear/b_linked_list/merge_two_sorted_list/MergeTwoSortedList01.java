package algo.interview.b_linear.b_linked_list.merge_two_sorted_list;

public class MergeTwoSortedList01 {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode mergeTwoSortedList(ListNode list1, ListNode list2) {

        // 두 노드 중 한쪽이 null이면, null이 아닌 노드를 리턴 (종료조건)
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        // 비교
        if (list1.val <= list2.val) {
            list1.next = mergeTwoSortedList(list1.next, list2);
            return list1;
        } else { // list1.val > list2.val
            list2.next = mergeTwoSortedList(list1, list2.next);
            return list2;
        }

    }

    public static void main(String[] args) {

        // 1 -> 2 -> 5
        ListNode headA = new ListNode(1);
        headA.next = new ListNode(2);
        headA.next.next = new ListNode(5);

        // 1 -> 3 -> 4
        ListNode headB = new ListNode(1);
        headB.next = new ListNode(3);
        headB.next.next = new ListNode(4);

        // 1 -> 1 -> 2 -> 3 -> 4 -> 5
        ListNode mergedHead = mergeTwoSortedList(headA, headB);
        while (mergedHead != null) {
            System.out.println(mergedHead.val);
            mergedHead = mergedHead.next;
        }
    }
}
