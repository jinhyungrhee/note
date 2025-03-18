package algo.interview.b_linear.b_linked_list.palindrome_linked_list;
import java.util.Deque;
import java.util.LinkedList;

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

public class PalindromeLinkedList02 {

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

        Deque<Integer> deque = new LinkedList<>();

        ListNode node = head;
        while (node != null) {
            deque.add(node.val);
            node = node.next;
        }

        // 짝수 -> 데크가 모두 비거나
        // 홀수 -> 남은 개수가 1개 이하일 때까지 비교
        while (!deque.isEmpty() && deque.size() > 1) {
            if (deque.pollFirst() != deque.pollLast()) {
                return false;
            }
        }

        return true;

    }
}
