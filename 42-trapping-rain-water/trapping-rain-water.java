class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] prefix = new int[n]; 
        int[] suffix = new int[n];
        int[] ans = new int[n];
        int leftMax = 0;
        int rightMax = 0;
        int totalWater = 0;

        for(int i =0; i <n; i++){
            leftMax = Math.max(leftMax, height[i]);
            prefix[i] = leftMax;
        } 
        
        for(int i =n -1; i >=0; i--){
            rightMax = Math.max(rightMax, height[i]);
            suffix[i] = rightMax;
        }

        for(int i =0; i <n; i++){
            ans[i] = Math.min(prefix[i], suffix[i]) -height[i];
        }

        for(int i =0; i <n; i++){
            totalWater += ans[i];
        }

        return totalWater;
        
    }
}