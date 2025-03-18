package algo.interview.b_linear.b_linked_list.palindrome_linked_list;
import java.util.Stack;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

public class PalindromeLinkedList01 {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void main(String[] args) {

        ListNode tail = new ListNode(1);
        ListNode node2 = new ListNode(2, tail);
        ListNode node1 = new ListNode(2, node2);
        ListNode head = new ListNode(1, node1);

        boolean result = isPalindrome(head);
        System.out.println(result);

    }

    public static boolean isPalindrome(ListNode head) {

        Stack<Integer> stack = new Stack<>();
        ListNode node = head;
        while (node != null) {
            stack.add(node.val);
            node = node.next;
        }

        while (head != null) {
            if (head.val != stack.pop()) {
                return false;
            }
            head = head.next;
        }

        return true;

    }
}
