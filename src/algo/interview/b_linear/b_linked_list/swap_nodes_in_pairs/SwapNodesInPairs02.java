package algo.interview.b_linear.b_linked_list.swap_nodes_in_pairs;

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
        node.next.next.next.next.next.next = new ListNode(7);
        node.next.next.next.next.next.next.next = new ListNode(8);

//        ListNode result = swapNodesInPairs(node);
//        ListNode result = swapNodesInPairsSecondAnswer(node);
        ListNode result = swapNodesInPairsThirdAnswer(node);

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

            // swap
            a.next = b.next;
            node.next = b;
            node.next.next = a;

            // move
            node = node.next.next;
        }

        return root.next;
    }

    public static ListNode swapNodesInPairsSecondAnswer(ListNode head) {

        ListNode node = new ListNode(0);
        node.next = head;

        ListNode root = node;

        while (node.next != null && node.next.next != null) {

            ListNode a = node.next; // 1
            ListNode b = node.next.next; // 2

            // swap
            a.next = b.next;
            b.next = a;
            node.next = b;

            // move
            node = node.next.next;
        }

        return root.next;
    }


    public static ListNode swapNodesInPairsThirdAnswer(ListNode head) {

        if (head == null || head.next == null) return null;

        // 새로운 head는 무조건 두 번째 head (swap시 newHead가 됨)
        ListNode newHead = head.next;
        ListNode prev = null; // dummy node 대신 pointer 사용
        ListNode curr = head;


        //  1    -  2   -  3
        // curr  second  nextPair
        while (curr != null && curr.next != null) {

            ListNode nextPair = curr.next.next;
            ListNode second = curr.next;

            // swap
            second.next = curr;
            curr.next = nextPair;

            // 이전 노드 발생 시 현재 노드와 연결 필요
            if (prev != null) {
                prev.next = second;
            }

            prev = curr;
            curr = nextPair;

        }
        return newHead;
    }
}

/**
 * Dummy Node 사용시 이점?
 *
 */