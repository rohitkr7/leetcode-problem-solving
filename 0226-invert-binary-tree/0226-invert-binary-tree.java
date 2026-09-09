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
    // DFS Solution
    // Time: O(n)
    // Space: O(h) - h is the height of the tree for auxiliary stack space
    // Pre-order (swap parent's children first, then recurse down)
    public TreeNode invertTree(TreeNode root) {
        if (root == null)
            return root;

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree(root.left);
        invertTree(root.right);

        return root;
    }

    // DFS - Post Order 
    // Post-order (recurse to leaves first, swap on the way back up)
    // More concise code, but slightly easier to get tripped up when tracing manually
    public TreeNode invertTree_postOrder(TreeNode root) {
        if (root == null) {
            return null;
        }

        // Recursively invert the left and right subtrees
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);

        // Swap the inverted subtrees
        root.left = right;
        root.right = left;

        return root;
    }

    // BFS Solution
    public TreeNode invertTree_bfs(TreeNode root) {
        if (root == null)
            return null;

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();

            // Swap children
            TreeNode temp = current.left;
            current.left = current.right;
            current.right = temp;

            // Push children to queue
            if (current.left != null)
                queue.offer(current.left);
            if (current.right != null)
                queue.offer(current.right);
        }

        return root;
    }

}