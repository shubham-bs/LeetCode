class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        
        maxHeap.addAll(Arrays.stream(stones).boxed().toList());

        while(maxHeap.size() > 1){
            int a = maxHeap.poll();
            int b = maxHeap.poll();
            if(a != b){
                maxHeap.offer(a -b);
            }
        }

        return maxHeap.isEmpty() ? 0: maxHeap.poll();
    }
}