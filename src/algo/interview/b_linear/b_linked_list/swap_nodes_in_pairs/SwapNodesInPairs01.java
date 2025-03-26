package algo.interview.b_linear.b_linked_list.swap_nodes_in_pairs;

public class SwapNodesInPairs01 {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void main(String[] args) {

        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        node.next.next.next.next.next = new ListNode(6);

        ListNode result = swapNodesInPairs(node);
        while(result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

    public static ListNode swapNodesInPairs(ListNode head) {

        ListNode node = head;

        while (node != null && node.next != null) {
            int tmp;
            tmp = node.val;
            node.val = node.next.val;
            node.next.val = tmp;

            node = node.next.next;
        }

        return head;
    }
}
