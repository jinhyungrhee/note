package algo.interview.b_linear.b_linked_list.swap_nodes_in_pairs;

import java.util.List;

public class SwapNodesInPairs02 {

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

        ListNode node = new ListNode(0);
        node.next = head;

        ListNode root = node;

        while (node.next != null && node.next.next != null) {

            ListNode a = node.next; // 1
            ListNode b = node.next.next; // 2


            a.next = b.next; // 1
            // 기존 node 연결리스트와의 관계가 명확함
            node.next = b;
            node.next.next = a;


            // 2개씩 이동
            node = node.next.next;
        }

        return root.next;
    }

    public static ListNode swapNodesInPairsWrongAnswer(ListNode head) {

        ListNode node = new ListNode(0);
        node.next = head;

        ListNode root = node;

        while (node.next != null && node.next.next != null) {

            ListNode a = node.next; // 1
            ListNode b = node.next.next; // 2


            // 기존 node 와의 연결관계가 불분명해짐
            // * b가 node와 연결이 끊어짐 *
            a.next = b.next;
            b.next = a;


            // 2개씩 이동
            node = node.next.next;
        }

        return root.next;
    }
}
