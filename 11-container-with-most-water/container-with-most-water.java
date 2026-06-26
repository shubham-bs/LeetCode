class Solution {
    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length -1;
        int maxA = 0;

        while(l < r){
            int currA = (r -l) * Math.min(height[l], height[r]);
            if(height[l] < height[r]){
                l++;
            }else{
                r--;
            }
            maxA = Math.max(maxA, currA);
        }
        
        return maxA;
    }
}