package leetcode;

import java.util.HashSet;

public class DetectLinkedListCycle {
    public ListNode detectCycle(ListNode head) {
        HashSet<ListNode> map = new HashSet<>();
        while (head != null) {
            if (!map.add(head)) break;
            head = head.next;
        }
        return head;
    }

    public ListNode detectCycle2(ListNode head) {
        if (head == null || head.next == null) return null;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) break;
        }
        if (slow != fast) return null;
        slow = head;
        while(slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
