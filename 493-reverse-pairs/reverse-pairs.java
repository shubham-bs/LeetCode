class Solution {
    int count = 0;
    public int reversePairs(int[] nums) {
        mergeSort(nums);
        return count;
    }

    private void mergeSort(int[] nums){
        int n = nums.length;
        if(n <= 1) return;

        int mid = n /2;
        int[] left = new int[mid];
        int[] right = new int[n - mid];

        for(int i = 0; i < mid; i++) left[i] = nums[i];
        for(int i = mid; i < n; i++) right[i - mid] = nums[i];

        mergeSort(left);
        mergeSort(right);

        merge(left, right, nums);
    }

    private void merge(int[] left, int[] right, int[] nums){
        int n = nums.length;

        int leftPtr = 0, rightPtr = 0;

        while(leftPtr < left.length && rightPtr < right.length){
            if(left[leftPtr] > 2L * right[rightPtr]){
                count += left.length - leftPtr;
                rightPtr++;
            }else leftPtr++;
        }
        int l = 0, r = 0, i = 0;

        while(l < left.length && r < right.length){
            if(left[l] <= right[r]){
                nums[i] = left[l];
                l++;
            }else{
                nums[i] = right[r];
                r++;
            }
            i++;
        } 

        while(l < left.length){
            nums[i] = left[l];
            l++;
            i++;
        }
        while(r < right.length){
            nums[i] = right[r];
            r++;
            i++;
        }
    }
}