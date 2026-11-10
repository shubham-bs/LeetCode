class Solution {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        int n = arrival.length;

        int[] count = new int[k];

        TreeSet<Integer> available = new TreeSet<>();

        PriorityQueue<long[]> busy = new PriorityQueue<>(
            (a, b) -> Long.compare(a[0], b[0])
        );

        for(int i = 0; i < k; i++) {
            available.add(i);
        }

        for(int i = 0; i < n; i++) {

            while(!busy.isEmpty() && busy.peek()[0] <= arrival[i]) {
                long[] curr = busy.poll();
                available.add((int)curr[1]);
            }

            if(available.isEmpty()) {
                continue;
            }

            int start = i % k;

            Integer server = available.ceiling(start);

            if(server == null) {
                server = available.first();
            }

            available.remove(server);

            count[server]++;

            busy.offer(new long[]{
                (long)arrival[i] + load[i], server
            });
        }

        int max = 0;

        for(int x : count) {
            max = Math.max(max, x);
        }

        List<Integer> ans = new ArrayList<>();

        for(int i = 0; i < k; i++) {
            if(count[i] == max) {
                ans.add(i);
            }
        }

        return ans;
    }
}