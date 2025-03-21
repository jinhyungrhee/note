package algo.interview.b_linear.b_linked_list.add_two_numbers;

import java.math.BigInteger;

public class AddTwoNumbers01 {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void main(String[] args) {

        ListNode node1 = new ListNode(2);
        node1.next = new ListNode(4);
        node1.next.next = new ListNode(3);

        ListNode node2 = new ListNode(5);
        node2.next = new ListNode(6);
        node2.next.next = new ListNode(2);

        ListNode result = addTwoNumbers(node1, node2);
        while(result != null) {
            System.out.println(result.val);
            result = result.next;
        }

    }

    public static ListNode reverseList(ListNode head) {
        ListNode prev = null, curr = head;
        while(curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static BigInteger toBigInt(ListNode node) {
        String val = "";
        while (node != null) {
            val += node.val;
            node = node.next;
        }
        return new BigInteger(val);
    }

    public static ListNode toReversedLinkedList(BigInteger val) {
        ListNode prev = null, node=null;
        for (char c : String.valueOf(val).toCharArray()) {
            node = new ListNode(Character.getNumericValue(c));
            node.next = prev;
            prev = node;
        }
        return node;
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l1Reversed = reverseList(l1);
        ListNode l2Reversed = reverseList(l2);

        BigInteger result = toBigInt(l1Reversed).add(toBigInt(l2Reversed));
        return toReversedLinkedList(result);
    }
}
