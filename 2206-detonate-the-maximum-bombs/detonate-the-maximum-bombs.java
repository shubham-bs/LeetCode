class Solution {
    public int maximumDetonation(int[][] bombs) {
        int m = bombs.length;
        List<List<Integer>> adjLs = new ArrayList<>();

        for(int i = 0; i < m; i++){
            adjLs.add(new ArrayList<>() {});
        }

        for(int i = 0; i < m; i++){
            for(int j = 0; j < m; j++){
                if(i != j){
                    long x = bombs[i][0] -bombs[j][0];
                    long y = bombs[i][1] -bombs[j][1];
                    long d = x*x + y*y;
                    long r = bombs[i][2];

                    if(d <= r*r) adjLs.get(i).add(j);
                }
            }
        }

        int ans = -1;

        for(int i = 0; i < adjLs.size(); i++){
            boolean[] vis = new boolean[m];
            ans = Math.max(ans, dfs(i, adjLs, vis));
        }

        return ans;
    }

    private int dfs(int node, List<List<Integer>> adjLs, boolean[] vis){
        vis[node] = true;
        int count = 1;

        for(int neighbor: adjLs.get(node)){
            if(!vis[neighbor]) count += dfs(neighbor, adjLs, vis);
        }

        return count;
    }
}