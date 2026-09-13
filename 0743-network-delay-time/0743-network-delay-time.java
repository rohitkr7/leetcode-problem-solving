class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        // Create the adjacency list
        // adj.get(currentNode) contains a list of [neighborNode, edgeWeight] pairs

        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        // Create all the times
        for (int[] time : times) {
            adj.get(time[0]).add(new int[] { time[1], time[2] });

            // As the problem is for a directed graph we no need to consider the reverse weights
            // adj.get(time[1]).add(new int[] {time[0], time[2]});
        }

        // Create duration array to maintain the shortest distances of the nodes from the source
        // The array is sized n + 1 because the nodes in this specific problem are labeled from 1 to n (1-based indexing)
        int[] duration = new int[n + 1];

        // Assign all the distances as infinity at the beginning
        Arrays.fill(duration, Integer.MAX_VALUE);

        // Create a min-heap, priority queue having {node, distance}
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));

        // Offer the k node to the priority queue and also set the distance
        pq.offer(new int[] { k, 0 }); // distance of source from itself is 0
        duration[k] = 0;

        while (!pq.isEmpty()) {
            int[] top = pq.poll();
            int currentNode = top[0];
            int currentWeight = top[1];

            // Check for stale distance and skip
            if (currentWeight > duration[currentNode]) {
                continue;
            }

            // Relax the times
            for (int[] node : adj.get(currentNode)) {
                int nextNode = node[0];
                int weight = node[1];

                int nextWeight = currentWeight + weight;

                if (nextWeight < duration[nextNode]) {
                    duration[nextNode] = nextWeight;
                    pq.offer(new int[] { nextNode, nextWeight });
                }
            }
        }

        // Check out of all the times which one is max, that will be the minimum required time
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            if (duration[i] == Integer.MAX_VALUE)
                return -1;
            if (duration[i] > answer)
                answer = duration[i];
        }

        return answer;
    }
}