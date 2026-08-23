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

    // Time Complexity: O(n) - Single pass through all n nodes
    // Space Complexity: O(1) - In-place pointer manipulation without extra memory
    public ListNode reverseList(ListNode head) {
        // Step 1: Initialize the tracking pointers
        // 'previous' starts as null because the original head will become the tail (pointing to null)
        ListNode previous = null;

        // 'current' starts at the head to begin processing from the first node
        ListNode current = head;

        // 'nxtNode' will temporarily store the rest of the list so we don't lose our place
        ListNode nxtNode;

        // Step 2: Traverse through every node until we reach beyond the end of the list
        while (current != null) {
            // A. SAVE: Store the reference to the next node before breaking the current connection
            nxtNode = current.next;

            // B. REVERSE: Point the current node's arrow backwards to the previous node
            current.next = previous;

            // C. ADVANCE PREVIOUS: Move 'previous' forward one step to take current's place
            previous = current;

            // D. ADVANCE CURRENT: Move 'current' forward to the saved next node
            current = nxtNode;
        }

        // Step 3: When current reaches null, 'previous' is sitting on the last valid node (the new head)
        return previous;
    }

    // Solution using a Stack
    // Time Complexity: O(n) - Two passes over the list
    // Space Complexity: O(n) - Explicit stack on heap memory
    public ListNode reverseList_UsingStack(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        Deque<ListNode> stack = new ArrayDeque<>();
        ListNode current = head;

        // 1. Push all nodes onto the stack
        while (current != null) {
            stack.push(current);
            current = current.next;
        }

        // 2. The top node becomes the new head
        ListNode newHead = stack.pop();
        current = newHead;

        // 3. Pop and rewire pointers
        while (!stack.isEmpty()) {
            current.next = stack.pop();
            current = current.next;
        }

        // 4. Terminate the new tail to prevent cycles
        current.next = null;

        return newHead;
    }

    // Using Recursion
    // Time Complexity: O(n) - Single pass
    // Space Complexity: O(n) - Call stack frames
    public ListNode reverseList_UsingRecursion(ListNode head) {
        // Base case: empty list or last node reached
        if (head == null || head.next == null) {
            return head;
        }

        // Recursively reach the end; newHead stays the original tail
        ListNode newHead = reverseList(head.next);

        // Make the next node point back to the current node
        head.next.next = head;

        // Break the original forward pointer to avoid cycles
        head.next = null;

        return newHead;
    }
}