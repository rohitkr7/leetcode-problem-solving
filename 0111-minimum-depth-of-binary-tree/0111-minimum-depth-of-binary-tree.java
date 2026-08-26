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
    public int minDepth(TreeNode root) {
        // Base case: an empty tree has a depth of 0
        if (root == null) {
            return 0;
        }

        // Queue to facilitate level-order traversal (BFS)
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);

        // Root level starts at depth 1
        int depth = 1;

        // Traverse the tree level by level
        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            // Process every node at the current level
            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();

                // If a leaf node (no children) is reached, return the current depth
                if (currentNode.left == null && currentNode.right == null) {
                    return depth;
                }

                // Add existing children to the queue for the next level
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }

            // Move to the next tree level
            depth++;
        }

        return depth;
    }

    // DFS Solution : Recursion using call stack
    public int minDepth_1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        // If left subtree is null, recurse on right subtree
        if (root.left == null) {
            return minDepth(root.right) + 1;
        }
        
        // If right subtree is null, recurse on left subtree
        if (root.right == null) {
            return minDepth(root.left) + 1;
        }
        
        // If both subtrees are not null, find the minimum depth of both subtrees
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }
}