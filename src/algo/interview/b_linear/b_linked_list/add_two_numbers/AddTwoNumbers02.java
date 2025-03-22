package algo.interview.b_linear.b_linked_list.add_two_numbers;

import java.math.BigInteger;

public class AddTwoNumbers02 {

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

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode temp = new ListNode(0);
        ListNode root = temp;

        int carry = 0;
        int sum = 0;
        int remainder = 0;

        // l1과 l2가 끝나도 자리올림(carry)이 남아 있다면 한 번 더 반복해야 함
        while (l1 != null || l2 != null || carry != 0) {
            sum = 0;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            remainder = (sum + carry) % 10;
            carry = (sum + carry) / 10;

            temp.next = new ListNode(remainder);
            temp = temp.next;
        }

        return root.next;
    }
}
