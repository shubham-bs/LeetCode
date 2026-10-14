class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] vis = new boolean[n];

        int ans = 0;

        for(int node = 0; node < n; node++){
            if(!vis[node]){
                ans++;
                dfs(node, isConnected, vis);
            }
        }

        return ans;
    }

    private void dfs(
        int node,
        int[][] isConnected,
        boolean[] vis
    ){
        vis[node] = true;

        for(int neighbor = 0; neighbor < isConnected[node].length; neighbor++){
            if(isConnected[node][neighbor] == 1 && !vis[neighbor]){
                dfs(neighbor, isConnected, vis);
            }
        }

    }
}