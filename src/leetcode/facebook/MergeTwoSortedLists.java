package leetcode.facebook;

import leetcode.ListNode;
import org.junit.Test;

public class MergeTwoSortedLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode head = null; ListNode prev = null;
        while(l1 != null && l2 != null) {
            if (prev == null) {
                prev = l1.val < l2.val ? l1 : l2;
            } else {
                prev.next = l1.val < l2.val ? l1 : l2;
                prev = prev.next;
            }

            if (l1.val < l2.val) l1 = l1.next;
            else l2 = l2.next;

            if (head == null) head = prev;
        }

        ListNode next = l1 != null ? l1 : l2;
        if (next != null) prev.next = next;

        return head;
    }

    @Test
    public void test() {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(20);
        l1.next.next = new ListNode(40);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        //l2.next.next = new ListNode(4);
        ListNode result = mergeTwoLists(l1, l2);
        while(result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}
