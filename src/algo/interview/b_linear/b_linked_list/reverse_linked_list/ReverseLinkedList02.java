package algo.interview.b_linear.b_linked_list.reverse_linked_list;

public class ReverseLinkedList02 {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode reverse(ListNode head) {

        ListNode prev = null, now = head;
        while (now != null) {
            // 다음 노드 임시 저장 (여기로 보내야함)
            ListNode next = now.next;
            // 현재 노드의 다음으로 이전 노드 저장
            now.next = prev;
            // 이전 노드는 현재 노드로 지정
            prev = now;
            // 미리 지정했던 다음 노드를 현재 노드로 변경
            now = next;
        }
        return prev;
    }

    public static void main(String[] args) {

        // 1->2->3->4->5->6
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        ListNode reversedHeadNode = reverse(head);
        while (reversedHeadNode != null) {
            System.out.println(reversedHeadNode.val);
            reversedHeadNode = reversedHeadNode.next;
        }

    }

}
