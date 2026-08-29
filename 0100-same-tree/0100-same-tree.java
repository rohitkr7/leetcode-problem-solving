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

    // BEST:: Recursive DFS Approach
    // Time: ON(n) - visit each node at least once where n is the minimum number of nodes between the two trees
    // Space: O(h) - uses the implicit call stack proportional to the tree height h (O(log N) balanced, O(N) worst-case skewed)
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // 1. Both nodes are null -> structural match at leaf level
        if (p == null && q == null) {
            return true;
        }

        // 2. One is null, or values don't match -> mismatch
        if (p == null || q == null || p.val != q.val) {
            return false;
        }

        // 3. Current node matches -> recursively check left and right subtrees
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

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

    public boolean isSameTree_iterativeDFS(TreeNode p, TreeNode q) {

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

    public boolean isSameTree_bfs(TreeNode p, TreeNode q) {
        // LinkedList allows storing null values safely
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(p);
        queue.offer(q);

        while (!queue.isEmpty()) {
            TreeNode node1 = queue.poll();
            TreeNode node2 = queue.poll();

            // 1. Both nodes are null -> leaf boundary reached, continue to next pair
            if (node1 == null && node2 == null) {
                continue;
            }

            // 2. Structural mismatch (one null, one not) OR value mismatch
            if (node1 == null || node2 == null || node1.val != node2.val) {
                return false;
            }

            // 3. Values match -> enqueue children pairs in level order (FIFO)
            queue.offer(node1.left);
            queue.offer(node2.left);
            queue.offer(node1.right);
            queue.offer(node2.right);
        }

        return true;
    }

}