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
    public ListNode removeNthFromEnd(ListNode head, int n) {

        // Time: O(sz) and O(1) space.
        ListNode dummy = new ListNode();
        dummy.next = head;

        ListNode fast = head, slow = dummy;
        int counter = 1;
        
        while (fast != null) {
            fast = fast.next;
            if (counter <= n) {
                counter++;
            }else{
                slow = slow.next;
            }
        }
        
        ListNode temp = slow.next;
        slow.next = temp.next;

        return dummy.next;
    }

    
}