/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    /*
    * APPROACH: Iterative DFS using a Stack (Pre-order-like traversal)
    * 
    * Strategy:
    * 1. Synchronous Traversal: Push corresponding nodes from both trees (p and q) 
    *    in pairs onto the stack.
    * 2. Invariant Check:
    *    - Both nodes null: Valid leaf boundary -> skip and continue.
    *    - Structural mismatch (one null, one not) OR value mismatch (p.val != q.val) -> return false.
    *    - Both match: Push left child pairs, then right child pairs.
    * 3. Completion: If the stack empties without mismatch, the trees are identical.
    * 
    * Complexity:
    * - Time Complexity:  O(N) -> Visits each node at most once, where N is the minimum number of nodes.
    * - Space Complexity: O(h) -> Proportional to tree height 'h' (O(log N) balanced, O(N) worst-case skewed).
    * 
    * Note:
    * - In production Java, prefer 'Deque<TreeNode> stack = new ArrayDeque<>()' over 'Stack<TreeNode>'
    *   to avoid unnecessary method-level synchronization overhead.
    */

    public boolean isSameTree(TreeNode p, TreeNode q) {

        TreeNode nodeP;
        TreeNode nodeQ;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(p);
        stack.push(q);

        while (!stack.isEmpty()) {
            nodeQ = stack.pop();
            nodeP = stack.pop();

            if (nodeP == null && nodeQ == null) {
                continue;
            }
            if (nodeP == null || nodeQ == null || nodeP.val != nodeQ.val) {
                return false;
            }

            stack.push(nodeP.left);
            stack.push(nodeQ.left);
            stack.push(nodeP.right);
            stack.push(nodeQ.right);
        }

        return true;
    }
}