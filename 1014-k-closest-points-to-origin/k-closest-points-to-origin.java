class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> (b[0]*b[0] + b[1]*b[1]) - (a[0]*a[0] + a[1]*a[1]));

        for(int[] point: points){

            if(maxHeap.size() < k){
                maxHeap.offer(point);
            }else{
                int[] top = maxHeap.peek();
                int topDist = top[0]*top[0] + top[1]*top[1];
                int currDist = point[0]*point[0] + point[1]*point[1];
                if(topDist > currDist){
                    maxHeap.poll();
                    maxHeap.offer(point);
                } 
            }
        }

        int[][] ans = new int[k][2];
        for(int i = 0; i < k; i++){
            ans[i] = maxHeap.poll();
        }

        return ans;
    }
}