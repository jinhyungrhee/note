package algo.interview.b_linear.b_linked_list.reverse_linked_list_ii;

public class ReverseLinkedListII {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void main(String[] args) {

    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
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
