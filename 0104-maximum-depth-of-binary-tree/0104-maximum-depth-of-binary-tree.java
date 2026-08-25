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
    // Recursion Solution - DFS - Depth First Search approach (Call Stack)
    // Time: O(n) - visiting every node exactly once
    // Space: O(H) - where H is the height of the tree (call stack deapth)
    // Overhead: Minimal call-stack overhead
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;

        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        return Integer.max(leftDepth, rightDepth) + 1;
    }

    // Breadth First Search - BFS
    // Time Complexity: O(N) — Every node is enqueued and dequeued exactly once.
    // Space Complexity: O(W) — Where W is the maximum width of the tree. In the worst case (a full binary tree), the queue holds up to ceil(N / 2)  nodes at the lowest level, which is O(N).
    // Overhead: Explicit heap allocation for Queue nodes
    public int maxDepth_bfs(TreeNode root) {
        // Base Case: An empty tree has a depth of 0
        if (root == null) {
            return 0;
        }

        // Initialize a FIFO queue to store nodes for level-by-level processing
        Queue<TreeNode> queue = new LinkedList<>();

        // Start BFS by pushing the root node
        queue.offer(root);
        int depth = 0;

        // Process the tree level by level until no nodes remain
        while (!queue.isEmpty()) {
            // Snapshot the number of nodes at the current level
            // This ensures we only process current level nodes in the inner loop
            int levelSize = queue.size();

            // Drain all nodes belonging to the current level
            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();

                // If a left child exists, add it to be processed in the next level
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }

                // If a right child exists, add it to be processed in the next level
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }

            // Increment depth counter only after fully exhausting the current level
            depth++;
        }

        return depth;
    }

    // Why DFS Wins Here ::
    // Memory Efficiency on Balanced Trees: Most typical binary trees are reasonably balanced. In a balanced tree, DFS space is O(\log N) on the call stack, whereas BFS must store the entire bottom layer in the queue (O(N)).
    // Conciseness: DFS naturally maps to the mathematical definition of tree height: 1 + max(left, right).

    // When BFS Would Be Preferred InsteadIf the tree is extremely deep and skewed (like a linked list with 10^5 nodes) where recursion might trigger a StackOverflowError.In problems where you need to find the minimum depth or search for a target near the root, because BFS can terminate early as soon as it hits the first leaf or match.
}