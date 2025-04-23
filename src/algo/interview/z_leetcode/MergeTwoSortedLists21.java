package algo.interview.z_leetcode;

public class MergeTwoSortedLists21 {

      public static class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }

      public static void main(String[] args) {

          ListNode list1 = new ListNode(1);
          list1.next = new ListNode(2);
          list1.next.next = new ListNode(3);

          ListNode list2 = new ListNode(1);
          list2.next = new ListNode(3);
          list2.next.next = new ListNode(4);

          ListNode mergedList = mergeTwoLists(list1, list2);
          while (mergedList != null) {
              System.out.println(mergedList.val);
              mergedList = mergedList.next;
          }

      }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode dummy = new ListNode(0);
        ListNode current = dummy; // ***실제로 노드를 이어나갈 포인터***

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                current.next = list1;
                list1 = list1.next;

            }
            else {
                current.next = list2;
                list2 = list2.next;
            }

            current = current.next;
            // System.out.println("CURR_VAL : " + current.val);
        }

        // 남아있는 노드들 이어붙이기
        if (list1 != null) {
            current.next = list1;
        }
        if (list2 != null) {
            current.next = list2;
        }

        return dummy.next;
    }
}
