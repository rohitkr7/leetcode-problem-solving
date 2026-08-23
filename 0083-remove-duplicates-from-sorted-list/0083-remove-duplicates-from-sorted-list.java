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

    // Time Complexity: O(n) where n is the number of nodes, as each curr is visited at most twice.
    // Space Complexity: O(1) auxiliary space, operating fully in-place.

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode curr = head;

        while (curr.next != null) {
            // Skip next curr without moving curr, so the pulled-up node is verified next (handles consecutive duplicate values nodes)
            if (curr.val == curr.next.val)
                curr.next = curr.next.next;
            else
                curr = curr.next;
        }

        return head;
    }
}