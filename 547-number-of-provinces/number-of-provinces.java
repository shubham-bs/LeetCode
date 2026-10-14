class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] vis = new boolean[n];
        List<List<Integer>> adjLs = new ArrayList<>();

        for(int i = 0; i < n; i++){
            adjLs.add(new ArrayList<>());
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(isConnected[i][j] == 1 && i != j){
                    adjLs.get(i).add(j);
                    adjLs.get(j).add(i);
                }
            }
        }

        int ans = 0;

        for(int node = 0; node < n; node++){
            if(!vis[node]){
                ans++;
                dfs(node, adjLs, vis);
            }
        }

        return ans;
    }

    private void dfs(
        int node,
        List<List<Integer>> adjLs,
        boolean[] vis
    ){
        vis[node] = true;

        for(int it: adjLs.get(node)){
            if(!vis[it]) dfs(it, adjLs, vis);
        }

    }
}