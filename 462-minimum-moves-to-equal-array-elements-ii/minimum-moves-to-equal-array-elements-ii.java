class Solution {
    public int minMoves2(int[] nums) {
        int n = nums.length;
        int k = 0;

        if((n & 1) == 0) k = n /2;
        else k = (n -1) /2;

        int median = quickSelect(nums, k);
        int ans = 0;

        for(int i = 0; i < n; i++){
            ans += Math.abs(median - nums[i]);
        }

        return ans;
    }

    private int quickSelect(int[] nums, int k){
        int l = 0;
        int r = nums.length - 1;

        while(l <= r){
            int pivotIndex = partition(nums, l, r);
            System.out.println(pivotIndex);

            if(pivotIndex == k) return nums[pivotIndex];
            else if(pivotIndex < k) l = pivotIndex +1;
            else r = pivotIndex -1;
        }

        return -1;
    }

    private int partition(int[] nums, int l, int r){
        int i = l;
        int pivot = nums[r];

        for(int j = l; j < r; j++){
            if(nums[j] < pivot){
                swap(nums, i, j);
                i++;
            }
        }

        swap(nums, i, r);

        System.out.println(pivot);

        return i;
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}