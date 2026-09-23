class Solution {
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        int l = 1;
        int r = n -1;

        while(l < r){
            int mid = l + (r -l)/ 2;
            int count = 0;

            for(int num: nums) if(num <= mid) count++;

            if(count > mid) r = mid;
            else l = mid +1;
        }

        return l;
    }
}