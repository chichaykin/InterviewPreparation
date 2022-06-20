package facebook;

import leetcode.ListNode;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

//https://leetcode.com/explore/interview/card/facebook/6/linked-list/3021/
//Given 1->2->3->4, reorder it to 1->4->2->3.
//Given 1->2->3->4->5, reorder it to 1->5->2->4->3.
//Given 1->6->2->5->3->4    , reorder it to 1->5->2->4->3.
public class ReorderList {

    public void reorderList(ListNode head) {
        ListNode node = head.next;
        ListNode second = null, prev = null;
        while (node != null) {
            ListNode next = node.next;
            if (second == null) {
                second = node;
                second.next = null;
            } else {
                node.next = second;
                second = node;
            }
            node = next;
        }
        head.next = second;
    }

    @Test
    public void test() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        reorderList(head);
        int[] result = new int[4];
        int i = 0;
        while(head != null) {
            result[i++] = head.val;
            head = head.next;
        }
        assertArrayEquals(new int[]{1,4,2,3}, result);
    }
}
