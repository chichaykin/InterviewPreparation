package leetcode.facebook;

import leetcode.ListNode;

public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = null, head = null;
        int rem = 0;
        while (l1 != null || l2 != null) {
            int val1 = l1 != null ? l1.val : 0;
            int val2 = l2 != null ? l2.val : 0;
            int num = rem + val1 + val2;
            rem = num / 10;
            ListNode prev = result;
            result = new ListNode(num % 10);
            if (prev != null) prev.next = result;
            if (head == null) head = result;
            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }

        if (rem > 0) {
            result.next = new ListNode(rem);
        }

        return head;
    }
}
