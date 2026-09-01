class Solution {
    private static final int[][] DIRS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int minMoves(String[] classroom, int maxEnergy) {
        int m = classroom.length;
        int n = classroom[0].length();
        
        int[] start = null;
        List<int[]> litterList = new ArrayList<>();
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char ch = classroom[i].charAt(j);
                if (ch == 'S') {
                    start = new int[]{i, j};
                } else if (ch == 'L') {
                    litterList.add(new int[]{i, j});
                }
            }
        }
        
        int totalLitter = litterList.size();
        if (totalLitter == 0) return 0; 

        List<int[]> targets = new ArrayList<>();
        targets.add(start);
        targets.addAll(litterList);
        int totalTargets = targets.size();

        int[][][] distMatrix = new int[totalTargets][totalTargets][maxEnergy + 1];
        for (int[][] matrix : distMatrix) {
            for (int[] row : matrix) {
                Arrays.fill(row, Integer.MAX_VALUE);
            }
        }

        for (int i = 0; i < totalTargets; i++) {
            int[][] localDist = bfsFromTarget(targets.get(i), classroom, maxEnergy, m, n);
            for (int j = 0; j < totalTargets; j++) {
                int tjRow = targets.get(j)[0];
                int tjCol = targets.get(j)[1];
                for (int e = 0; e <= maxEnergy; e++) {
                    distMatrix[i][j][e] = localDist[tjRow * n + tjCol][e];
                }
            }
        }

        int numStates = 1 << totalLitter;
        int[][][] dp = new int[numStates][totalTargets][maxEnergy + 1];
        for (int[][] maskState : dp) {
            for (int[] row : maskState) {
                Arrays.fill(row, Integer.MAX_VALUE);
            }
        }

        dp[0][0][maxEnergy] = 0;

        for (int mask = 0; mask < numStates; mask++) {
            for (int u = 0; u < totalTargets; u++) {
                for (int e = 0; e <= maxEnergy; e++) {
                    if (dp[mask][u][e] == Integer.MAX_VALUE) continue;

                    for (int v = 1; v <= totalTargets - 1; v++) {
                        int bit = v - 1;
                        if ((mask & (1 << bit)) != 0) continue;

                        for (int nextE = 0; nextE <= maxEnergy; nextE++) {
                            int cost = distMatrix[u][v][e];
                            int pathMoves = distMatrix[u][v][e];
                            if (pathMoves == Integer.MAX_VALUE) continue;
                        }
                    }
                }
            }
        }

        return runGridBFS(start, classroom, maxEnergy, totalLitter, m, n, litterList);
    }

    private int runGridBFS(int[] start, String[] classroom, int maxEnergy, int totalLitter, int m, int n, List<int[]> litterList) {
        int numStates = 1 << totalLitter;
        boolean[][][][] visited = new boolean[m][n][numStates][maxEnergy + 1];
        
        int[][] litterIdx = new int[m][n];
        for (int i = 0; i < m; i++) Arrays.fill(litterIdx[i], -1);
        for (int i = 0; i < totalLitter; i++) {
            litterIdx[litterList.get(i)[0]][litterList.get(i)[1]] = i;
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{start[0], start[1], 0, maxEnergy, 0});
        visited[start[0]][start[1]][0][maxEnergy] = true;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int r = curr[0], c = curr[1], mask = curr[2], eng = curr[3], steps = curr[4];

            if (mask == numStates - 1) {
                return steps;
            }

            for (int[] d : DIRS) {
                int nr = r + d[0];
                int nc = c + d[1];

                if (nr >= 0 && nr < m && nc >= 0 && nc < n && classroom[nr].charAt(nc) != 'X') {
                    int nextEng = eng - 1;
                    if (nextEng < 0) continue; 

                    char cellType = classroom[nr].charAt(nc);
                    if (cellType == 'R') {
                        nextEng = maxEnergy; 
                    }

                    int nextMask = mask;
                    if (cellType == 'L' && litterIdx[nr][nc] != -1) {
                        nextMask |= (1 << litterIdx[nr][nc]);
                    }

                    if (!visited[nr][nc][nextMask][nextEng]) {
                        visited[nr][nc][nextMask][nextEng] = true;
                        queue.offer(new int[]{nr, nc, nextMask, nextEng, steps + 1});
                    }
                }
            }
        }
        return -1;
    }

    private int[][] bfsFromTarget(int[] start, String[] classroom, int maxEnergy, int m, int n) {
        int[][] dist = new int[m * n][maxEnergy + 1];
        for (int[] row : dist) Arrays.fill(row, Integer.MAX_VALUE);
        
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{start[0], start[1], maxEnergy, 0});
        dist[start[0] * n + start[1]][maxEnergy] = 0;

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int r = curr[0], c = curr[1], eng = curr[2], d = curr[3];

            if (d > dist[r * n + c][eng]) continue;

            for (int[] dir : DIRS) {
                int nr = r + dir[0];
                int nc = c + dir[1];

                if (nr >= 0 && nr < m && nc >= 0 && nc < n && classroom[nr].charAt(nc) != 'X') {
                    int nEng = eng - 1;
                    if (nEng < 0) continue;

                    char nextChar = classroom[nr].charAt(nc);
                    if (nextChar == 'R') nEng = maxEnergy;

                    if (d + 1 < dist[nr * n + nc][nEng]) {
                        dist[nr * n + nc][nEng] = d + 1;
                        q.offer(new int[]{nr, nc, nEng, d + 1});
                    }
                }
            }
        }
        return dist;
    }
}
