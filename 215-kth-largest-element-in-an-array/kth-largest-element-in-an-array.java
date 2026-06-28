class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for(int num: nums){
            maxHeap.offer(num);
        }
        while(k != 1){
            maxHeap.poll();
            k--;
        }

        return maxHeap.peek();
    }
}