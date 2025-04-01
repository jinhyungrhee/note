package algo.interview.b_linear.b_linked_list.reverse_linked_list_ii;

public class ReverseLinkedListII {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        int left = 3;
        int right = 5;

        ListNode result = reverseBetween(head, left, right);
        while(result != null) {
            System.out.println(result.val);
            result = result.next;
        }

    }

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null) return null;

        ListNode root = new ListNode(0);
        root.next = head;

        ListNode start = root;
        for (int i = 0; i < left - 1; i++) {
            start = start.next;
        }

        ListNode end = start.next;
        for (int i = 0; i < right - left; i++) {
            ListNode tmp = start.next;
            start.next = end.next;
            end.next = end.next.next;
            start.next.next = tmp;
        }

        return root.next;
    }
}
