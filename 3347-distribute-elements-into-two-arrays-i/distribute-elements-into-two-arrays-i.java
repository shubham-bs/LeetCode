class Solution {
    public int[] resultArray(int[] nums) {
        List<Integer> arr1 = new ArrayList<>();
        List<Integer> arr2 = new ArrayList<>();
        int idx1 = 1, idx2 = 1;
        arr1.add(nums[0]);
        arr2.add(nums[1]);

        for(int i = 2; i < nums.length; i++){
            if(arr1.get(idx1 -1) > arr2.get(idx2 -1)){
                arr1.add(nums[i]);
                idx1++;
            }else{
                arr2.add(nums[i]);
                idx2++;
            }
        }

        int[] ans = new int[nums.length];
        for(int i = 0; i < idx1; i++){
            ans[i] = arr1.get(i);
        }

        for(int i = 0; i < idx2; i++){
            ans[i +idx1] = arr2.get(i);
        }

        return ans;
    }
}