class Solution {
    public List<Integer> maxActiveSectionsAfterTrade(String s, int[][] queries) {
        int n = s.length();
        int totalOnes = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') {
                totalOnes++;
            }
        }

        // Identify all blocks of '1's
        int[] tempA = new int[n];
        int[] tempB = new int[n];
        int m = 0;
        
        int i = 0;
        while (i < n) {
            if (s.charAt(i) == '1') {
                int start = i;
                while (i < n && s.charAt(i) == '1') {
                    i++;
                }
                tempA[m] = start;
                tempB[m] = i - 1;
                m++;
            } else {
                i++;
            }
        }

        int[] A = Arrays.copyOf(tempA, m);
        int[] B = Arrays.copyOf(tempB, m);
        
        List<Integer> ans = new ArrayList<>(queries.length);
        if (m == 0) {
            for (int q = 0; q < queries.length; q++) {
                ans.add(totalOnes);
            }
            return ans;
        }

        // Precompute the boundaries of the 0-blocks surrounding each 1-block
        int[] A0 = new int[m];
        int[] B0 = new int[m];
        int[] C = new int[m]; // Total surrounding 0s for each block

        for (int j = 0; j < m; j++) {
            A0[j] = (j == 0) ? 0 : B[j - 1] + 1;
            B0[j] = (j == m - 1) ? n - 1 : A[j + 1] - 1;
            C[j] = B0[j] - A0[j] - (B[j] - A[j]);
        }

        // Build Sparse Table for Range Maximum Query on C
        int K = 32 - Integer.numberOfLeadingZeros(m);
        int[][] st = new int[K][m];
        System.arraycopy(C, 0, st[0], 0, m);

        for (int j = 1; j < K; j++) {
            int len = 1 << (j - 1);
            for (int r = 0; r <= m - (1 << j); r++) {
                st[j][r] = Math.max(st[j - 1][r], st[j - 1][r + len]);
            }
        }

        // Process each query
        for (int q = 0; q < queries.length; q++) {
            int l = queries[q][0];
            int r = queries[q][1];

            // Find the range of eligible 1-blocks strictly inside [l+1, r-1]
            int iMin = bisectRight(A, l);
            int iMax = bisectLeft(B, r) - 1;

            if (iMin > iMax) {
                ans.add(totalOnes);
                continue;
            }

            int maxGain = 0;
            // Check the boundary blocks individually
            maxGain = Math.max(maxGain, getGain(iMin, l, r, A, B, A0, B0));
            if (iMin != iMax) {
                maxGain = Math.max(maxGain, getGain(iMax, l, r, A, B, A0, B0));
            }

            // Query the internal blocks using the Sparse Table
            if (iMin + 1 <= iMax - 1) {
                maxGain = Math.max(maxGain, queryMax(st, iMin + 1, iMax - 1));
            }

            ans.add(totalOnes + maxGain);
        }

        return ans;
    }

    private int getGain(int idx, int l, int r, int[] A, int[] B, int[] A0, int[] B0) {
        int leftBound = Math.max(l, A0[idx]);
        int rightBound = Math.min(r, B0[idx]);
        return rightBound - leftBound - (B[idx] - A[idx]);
    }

    private int queryMax(int[][] st, int L, int R) {
        if (L > R) return 0;
        int j = 32 - Integer.numberOfLeadingZeros(R - L + 1) - 1;
        return Math.max(st[j][L], st[j][R - (1 << j) + 1]);
    }

    private int bisectRight(int[] arr, int target) {
        int low = 0, high = arr.length;
        while (low < high) {
            int mid = (low + high) >>> 1;
            if (arr[mid] <= target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    private int bisectLeft(int[] arr, int target) {
        int low = 0, high = arr.length;
        while (low < high) {
            int mid = (low + high) >>> 1;
            if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}
