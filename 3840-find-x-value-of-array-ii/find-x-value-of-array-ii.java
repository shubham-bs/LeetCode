class Solution {
    int K;
    int[][] treeCounts;
    int[] treeProduct;
    int N;

    public int[] resultArray(int[] nums, int k, int[][] queries) {
        this.K = k;
        this.N = nums.length;
        
        treeCounts = new int[4 * N][K];
        treeProduct = new int[4 * N];
        
        build(1, 0, N - 1, nums);
        
        int[] result = new int[queries.length];
        
        for (int i = 0; i < queries.length; i++) {
            int idx = queries[i][0];
            int val = queries[i][1];
            int start = queries[i][2];
            int x = queries[i][3];
            
            update(1, 0, N - 1, idx, val);
            
            int[] counts = query(1, 0, N - 1, start, N - 1);
            
            result[i] = counts[x];
        }
        
        return result;
    }
    
    private void build(int node, int start, int end, int[] nums) {
        if (start == end) {
            int rem = nums[start] % K;
            treeProduct[node] = rem;
            treeCounts[node][rem] = 1;
            return;
        }
        
        int mid = start + (end - start) / 2;
        build(2 * node, start, mid, nums);
        build(2 * node + 1, mid + 1, end, nums);
        
        merge(node);
    }
    
    private void update(int node, int start, int end, int idx, int val) {
        if (start == end) {
            for (int i = 0; i < K; i++) {
                treeCounts[node][i] = 0;
            }
            int rem = val % K;
            treeProduct[node] = rem;
            treeCounts[node][rem] = 1;
            return;
        }
        
        int mid = start + (end - start) / 2;
        if (idx <= mid) {
            update(2 * node, start, mid, idx, val);
        } else {
            update(2 * node + 1, mid + 1, end, idx, val);
        }
        
        merge(node);
    }
    
    private void merge(int node) {
        int leftChild = 2 * node;
        int rightChild = 2 * node + 1;
        
        treeProduct[node] = (treeProduct[leftChild] * treeProduct[rightChild]) % K;
        
        for (int i = 0; i < K; i++) {
            treeCounts[node][i] = treeCounts[leftChild][i];
        }
        
        int leftProd = treeProduct[leftChild];
        for (int j = 0; j < K; j++) {
            int newRem = (leftProd * j) % K;
            treeCounts[node][newRem] += treeCounts[rightChild][j];
        }
    }
    
    private int[] query(int node, int start, int end, int l, int r) {
        if (start >= l && end <= r) {
            int[] res = new int[K + 1];
            System.arraycopy(treeCounts[node], 0, res, 0, K);
            res[K] = treeProduct[node]; 
            return res;
        }
        
        int mid = start + (end - start) / 2;
        
        if (r <= mid) {
            return query(2 * node, start, mid, l, r);
        }
        if (l > mid) {
            return query(2 * node + 1, mid + 1, end, l, r);
        }
        
        int[] leftRes = query(2 * node, start, mid, l, r);
        int[] rightRes = query(2 * node + 1, mid + 1, end, l, r);
        
        int[] mergedRes = new int[K + 1];
        mergedRes[K] = (leftRes[K] * rightRes[K]) % K;
        
        for (int i = 0; i < K; i++) {
            mergedRes[i] = leftRes[i];
        }
        
        int leftProd = leftRes[K];
        for (int j = 0; j < K; j++) {
            int newRem = (leftProd * j) % K;
            mergedRes[newRem] += rightRes[j];
        }
        
        return mergedRes;
    }
}
