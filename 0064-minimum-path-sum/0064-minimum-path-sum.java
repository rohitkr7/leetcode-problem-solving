class Solution {
    // Dynamic Programming: breaks down complex problems into smaller
    // Better Explaination: https://algo.monster/liteproblems/64
    // Create a matrix of same size having first row and first column their corresponding sums
    // Rest of the elements in the matrix will have the currentSum as lesser value either from their left or top
    // Time Complexity: O(mxn)
    // Space Complexity: O(mxn)

    // Method to find the minimum path sum in a grid.
    public int minPathSum(int[][] grid) {
        // m and n store the dimensions of the grid.
        int m = grid.length, n = grid[0].length;

        // dp array stores the minimum path sums.
        int[][] dp = new int[m][n];

        // Initialize top-left cell with its own value as this is the starting point.
        dp[0][0] = grid[0][0];

        // Fill in the first column (vertical path) by accumulating values.
        for (int i = 1; i < m; ++i) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }

        // Fill in the first row (horizontal path) by accumulating values.
        for (int j = 1; j < n; ++j) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }

        // Fill in the rest of the grid. 
        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                // The cell dp[i][j] is the minimum of the cell above or to the left of it,
                // plus the value in the current cell of the grid.
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }

        // Return the bottom-right cell which contains the min path sum from top-left to
        // bottom-right.
        return dp[m - 1][n - 1];
    }

    // Dijkstra Approach
    // DP solution should be used for this problem as that is better for DAG: Directed Acyclic Graphs
    // In this case the constraints to move only down or right says its a directed graph and acyclic
    // Optimal Efficiency: When working with a DAG, you do not need the overhead of a priority queue to figure out which node to process next. A Dynamic Programming approach takes advantage of the grid's natural topological order. By simply iterating row by row and column by column, it calculates the optimal path in just O(M * N) time.
    public int minPathSum_Dijkstra(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        //pathSums[r][c] = minimum pathSum to reach grid[r][c] from grid[0][0]
        int[][] pathSums = new int[rows][cols];
        for (int[] row : pathSums) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        pathSums[0][0] = grid[0][0];

        //the heap holds [row, col, pathSumSoFar]
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));
        pq.offer(new int[] { 0, 0, pathSums[0][0] });

        int[][] directions = { { 1, 0 }, { 0, 1 } };

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int currentRow = current[0];
            int currentCol = current[1];
            int currentSum = current[2];

            //the first time we pop the bottom-right cell, its pathSums is already optimal
            if (currentRow == rows - 1 && currentCol == cols - 1)
                return currentSum;

            //stale entry, a cheaper path to this cell was already settled
            if (currentSum > pathSums[currentRow][currentCol])
                continue;

            for (int[] dir : directions) {
                int nextRow = currentRow + dir[0];
                int nextCol = currentCol + dir[1];

                if (nextRow < 0 || nextRow >= rows || nextCol < 0 || nextCol >= cols)
                    continue;

                int nextSum = currentSum + grid[nextRow][nextCol];

                if (nextSum < pathSums[nextRow][nextCol]) {
                    pathSums[nextRow][nextCol] = nextSum;
                    pq.offer(new int[] { nextRow, nextCol, nextSum });
                }

            }
        }

        return pathSums[rows - 1][cols - 1];
    }
}