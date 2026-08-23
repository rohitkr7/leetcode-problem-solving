/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {

    // Time: O(n) and Space:  O(1)
    public ListNode removeElements_1(ListNode head, int val) {

        while (head != null && head.val == val) {
            head = head.next;
        }

        ListNode prev = new ListNode(0, head);
        ListNode curr = head;
        while (curr != null) {
            if (curr.val == val)
                prev.next = curr.next;
            else
                prev = curr;

            curr = curr.next;
        }

        return head;
    }

    // Clean Solution
    public ListNode removeElements(ListNode head, int val) {
        // Create a dummy node pointing to the original head
        ListNode dummy = new ListNode(0, head);
        ListNode curr = dummy;

        while (curr.next != null) {
            if (curr.next.val == val) {
                // Skip target node without moving curr, so the pulled-up node is verified next (handles consecutive targets)
                curr.next = curr.next.next;
            } else {
                // curr.next is valid; safe to advance
                curr = curr.next;
            }
        }

        return dummy.next;
    }
}