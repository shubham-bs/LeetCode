class Solution {
    public int findMin(int[] nums) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for(int num: nums){
            minHeap.offer(num);
        }

        return minHeap.peek();
    }
}