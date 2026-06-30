class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> freq = new HashMap<>();

        for(int num: nums){
            freq.put(num, freq.getOrDefault(num, 0) +1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>((a, b) -> a.getValue() -b.getValue());

        for(Map.Entry<Integer, Integer> e: freq.entrySet()){
            if(minHeap.size() < k){
                minHeap.offer(e);
            }else if(minHeap.peek().getValue() < e.getValue()){
                minHeap.poll();
                minHeap.offer(e);
            }
        }

        int[] res = new int[k];
        for(int i =0; i< k; i++){
            res[i] = minHeap.poll().getKey();
        }

        return res;
    }
}