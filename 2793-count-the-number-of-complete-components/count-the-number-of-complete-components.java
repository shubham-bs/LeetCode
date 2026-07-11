class Solution {

    List<Integer>[] graph;
    boolean[] visited;

    int nodeCount;
    int edgeCount;

    public int countCompleteComponents(int n, int[][] edges) {

        graph = new ArrayList[n];
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        int complete = 0;

        for (int i = 0; i < n; i++) {

            if (!visited[i]) {

                nodeCount = 0;
                edgeCount = 0;

                dfs(i);

                // Every undirected edge was counted twice
                edgeCount /= 2;

                if (edgeCount == nodeCount * (nodeCount - 1) / 2) {
                    complete++;
                }
            }
        }

        return complete;
    }

    private void dfs(int node) {

        visited[node] = true;
        nodeCount++;

        edgeCount += graph[node].size();

        for (int neighbor : graph[node]) {
            if (!visited[neighbor]) {
                dfs(neighbor);
            }
        }
    }
}