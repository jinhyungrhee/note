package algo.interview.b_linear.b_linked_list.swap_nodes_in_pairs;

public class SwapNodesInPairs03 {

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


//        ListNode result = swapNodesInPairs(node);
        ListNode result = swapNodesInPairsV2(node);
        while(result != null) {
            System.out.println(result.val);
            result = result.next;
        }

    }

    public static ListNode swapNodesInPairs(ListNode head) {

       if(head != null && head.next != null) {

           // swap
           ListNode tmp = head.next;
           head.next = swapNodesInPairs(head.next.next);
           tmp.next = head;

           return tmp;
       }

       return head; // null
    }


    public static ListNode swapNodesInPairsV2(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        // swap
        ListNode tmp = head.next;
        head.next = swapNodesInPairsV2(head.next.next);
        tmp.next = head;

        return tmp;

    }
}
