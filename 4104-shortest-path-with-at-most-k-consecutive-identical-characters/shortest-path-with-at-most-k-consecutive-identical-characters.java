class Solution {

    static class Edge {
        int to;
        int weight;

        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    static class State implements Comparable<State> {
        int node;
        int run;
        long dist;

        State(int node, int run, long dist) {
            this.node = node;
            this.run = run;
            this.dist = dist;
        }

        @Override
        public int compareTo(State other) {
            return Long.compare(this.dist, other.dist);
        }
    }

    public int shortestPath(
            int n,
            int[][] edges,
            String labels,
            int k
    ) {
        List<List<Edge>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {

            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            graph.get(u).add(new Edge(v, w));
        }

        long[][] dist = new long[n][k + 1];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Long.MAX_VALUE);
        }

        dist[0][1] = 0;

        PriorityQueue<State> pq = new PriorityQueue<>();

        pq.offer(new State(0, 1, 0));

        while (!pq.isEmpty()) {

            State curr = pq.poll();

            int node = curr.node;
            int run = curr.run;
            long d = curr.dist;


            if (d != dist[node][run]) {
                continue;
            }


            if (node == n - 1) {
                return (int) d;
            }

            for (Edge edge : graph.get(node)) {

                int next = edge.to;
                int weight = edge.weight;

                int newRun;

                if (labels.charAt(next)
                        == labels.charAt(node)) {

                    newRun = run + 1;

                } else {

                    newRun = 1;
                }


                if (newRun > k) {
                    continue;
                }


                long newDist = d + weight;


                if (newDist < dist[next][newRun]) {

                    dist[next][newRun] = newDist;

                    pq.offer(
                        new State(
                            next,
                            newRun,
                            newDist
                        )
                    );
                }
            }
        }


        return -1;
    }
}