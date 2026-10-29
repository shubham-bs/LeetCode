class Solution {
    int n;
    List<List<Integer>> adj;

    int[] tin, tout, depth;
    int[] charMask;
    int[] basePrefix;

    int[][] up;
    int LOG;
    int timer;

    int[] bit;
    
    public List<Boolean> palindromePath(int n, int[][] edges, String s, String[] queries) {
        this.n = n;

        adj = new ArrayList<>();
        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());

        for(int[] edge: edges){
            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        charMask = new int[n];
        for(int i = 0; i < n; i++) charMask[i] = 1 << (s.charAt(i) -'a');

        LOG = 1;
        while((1 << LOG) <= n) LOG++;

        up = new int[LOG][n];

        tin = new int[n];
        tout = new int[n];
        depth = new int[n];
        basePrefix = new int[n];

        timer = 0;

        dfs(0, 0, 0);

        for (int j = 1; j < LOG; j++) {
            for (int node = 0; node < n; node++) {
                up[j][node] = up[j - 1][up[j - 1][node]];
            }
        }

        bit = new int[n + 2];

        List<Boolean> answer = new ArrayList<>();

        for (String query : queries) {
            String[] parts = query.split(" ");

            if (parts[0].equals("update")){
                int node = Integer.parseInt(parts[1]);
                char c = parts[2].charAt(0);

                update(node, c);

            } else{
                int u = Integer.parseInt(parts[1]);
                int v = Integer.parseInt(parts[2]);

                answer.add(canPalindrome(u, v));
            }
        }

        return answer;
    }

    private void dfs(int node, int parent, int prefix) {
        tin[node] = timer++;
        up[0][node] = parent;

        basePrefix[node] =prefix ^ charMask[node];

        for (int next : adj.get(node)) {
            if (next == parent) continue;

            depth[next] = depth[node] + 1;

            dfs(next, node, basePrefix[node]);
        }

        tout[node] = timer - 1;
    }

    private int lca(int u, int v) {
        if (depth[u] < depth[v]) {
            int temp = u;
            u = v;
            v = temp;
        }

        int diff = depth[u] - depth[v];

        for (int j = 0; j < LOG; j++) if ((diff & (1 << j)) != 0) u = up[j][u];

        if (u == v) return u;

        for (int j = LOG - 1; j >= 0; j--) {
            if (up[j][u] != up[j][v]) {
                u = up[j][u];
                v = up[j][v];
            }
        }

        return up[0][u];
    }

     private void bitUpdate(int index, int value) {
        index++;

        while (index <= n) {
            bit[index] ^= value;
            index += index & -index;
        }
    }

    private int bitQuery(int index) {
        index++;
        int result = 0;

        while (index > 0) {
            result ^= bit[index];
            index -= index & -index;
        }

        return result;
    }

    private void rangeXor(
            int left,
            int right,
            int value
    ) {

        bitUpdate(left, value);
        bitUpdate(right + 1, value);
    }

     private int getPrefix(int node) {
        return basePrefix[node] ^ bitQuery(tin[node]);
    }

     private void update(int node, char c) {
        int oldMask = charMask[node];
        int newMask = 1 << (c - 'a');

        if (oldMask == newMask) return;

        int delta = oldMask ^ newMask;

        charMask[node] = newMask;

        rangeXor(
                tin[node],
                tout[node],
                delta
        );
    }

     private boolean canPalindrome(int u, int v) {
        int ancestor = lca(u, v);

        int prefixU = getPrefix(u);
        int prefixV = getPrefix(v);

        int pathMask = prefixU ^ prefixV ^ charMask[ancestor];

        return Integer.bitCount(pathMask) <= 1;
    }

}