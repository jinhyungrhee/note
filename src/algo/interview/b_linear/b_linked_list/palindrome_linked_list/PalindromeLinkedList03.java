package algo.interview.b_linear.b_linked_list.palindrome_linked_list;

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

public class PalindromeLinkedList03 {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void main(String[] args) {

        // case1 (짝수개) : 1 -> 2 -> 2 -> 1
//        ListNode tail = new ListNode(1);
//        ListNode node2 = new ListNode(2, tail);
//        ListNode node1 = new ListNode(2, node2);
//        ListNode head = new ListNode(1, node1);

        // case2 (홀수개) : 1 -> 2 -> 3 -> 2 -> 1
        ListNode tail = new ListNode(1);
        ListNode node3 = new ListNode(2, tail);
        ListNode node2 = new ListNode(3, node3);
        ListNode node1 = new ListNode(2, node2);
        ListNode head = new ListNode(1, node1);


        boolean result = isPalindrome(head);
        System.out.println(result);

    }

    // Runner 이용한 풀이
    public static boolean isPalindrome(ListNode head) {

        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        // 홀수 개일 경우, 느린 러너가 한 칸더 앞으로 감
        if (fast != null) {
            slow = slow.next;
        }

        // *** 중간에 도달한 느린 러너로 '역순 연결 리스트' 생성 ***
        // => 연결리스트의 중간부터 끝까지를 역순으로 뒤집는 과정!
        ListNode rev = null;
        while (slow != null) {
            ListNode tmp = slow.next;
            slow.next = rev;
            rev = slow;
            slow = tmp;
        }

        // rev 연결리스트와 기존 연결리스트 비교
        while (rev != null) {
            if (rev.val != head.val) {
                return false;
            }
            rev = rev.next;
            head = head.next;
        }
        return true;
    }
}
