/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {

    // Time: O(n)
    // Space: O(n)
    public boolean hasCycle_UsingHashSet(ListNode head) {
        HashSet<ListNode> hs = new HashSet<ListNode>();
        ListNode node = head;
        while (node != null) {
            if (hs.contains(node))
                return true;
            hs.add(node);
            node = node.next;
        }
        return false;
    }

    // Time: O(n)
    // Space: O(1)
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }

        return false;
    }
}