class Solution {
    public int minimumEffortPath(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;

        //effort[r][c] = the smallest possible "largest single step" to reach (r, c)
        int[][] effort = new int[rows][cols];
        for (int[] row : effort) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        effort[0][0] = 0;

        //the heap holds [row, col, effortSoFar]
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));
        pq.offer(new int[] { 0, 0, 0 });

        int[][] directions = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int currentRow = current[0];
            int currentCol = current[1];
            int currentEffort = current[2];

            //the first time we pop the bottom-right cell, its effort is already optimal
            if (currentRow == rows - 1 && currentCol == cols - 1)
                return currentEffort;

            //stale entry, a cheaper path to this cell was already settled
            if (currentEffort > effort[currentRow][currentCol])
                continue;

            for (int[] dir : directions) {
                int nextRow = currentRow + dir[0];
                int nextCol = currentCol + dir[1];

                if (nextRow < 0 || nextRow >= rows || nextCol < 0 || nextCol >= cols)
                    continue;

                int step = Math.abs(heights[nextRow][nextCol] - heights[currentRow][currentCol]);
                int candidate = Math.max(step, currentEffort);

                if (candidate < effort[nextRow][nextCol]) {
                    effort[nextRow][nextCol] = candidate;
                    pq.offer(new int[] { nextRow, nextCol, candidate });
                }

            }
        }
        //a grid is always connected, so we only get here for a 1x1 grid
        return 0;
    }
}