package algo.interview.b_linear.b_linked_list.reverse_linked_list;

public class ReverseLinkedList01 {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode reverse(ListNode node, ListNode prev) {

        if (node == null) return prev;

        ListNode temp = node.next; // 임시저장(temp)
        node.next = prev; // 초기 null

        return reverse(temp, node);
    }

    public static void main(String[] args) {

        // 1->2->3->4->5->6
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        ListNode reversedHeadNode = reverse(head, null);

        while (reversedHeadNode != null) {
            System.out.println(reversedHeadNode.val);
            reversedHeadNode = reversedHeadNode.next;
        }

    }

}
