package algo.interview.b_linear.b_linked_list.odd_even_linked_list;

public class OddEvenLinkedList01 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

    }

    public static void main(String[] args) {

        // case1 : even number of nodes
//        ListNode head = new ListNode(1);
//        head.next = new ListNode(2);
//        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(4);
//        head.next.next.next.next = new ListNode(5);
//        head.next.next.next.next.next = new ListNode(6);

        // case2 : odd number of nodes
        ListNode head = new ListNode(2);
        head.next = new ListNode(1);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(5);
        head.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next.next = new ListNode(7);

        ListNode result = oddEvenLinkedList(head);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }

    }

    public static ListNode oddEvenLinkedList(ListNode head) {

        ListNode oddHead = head;
        ListNode odd = head;
        ListNode evenHead = head.next;
        ListNode even = head.next;

//        while (odd != null && even.next != null) {
        // -> Cannot read field "next" because "even" is null
        while (even != null && even.next != null) {

            odd.next = odd.next.next;
            odd = odd.next;

            even.next = even.next.next;
            even = even.next;
        }

        odd.next = evenHead;

        return oddHead;
    }
}

/**
 * https://leetcode.com/problems/odd-even-linked-list/description/
 */
