class Solution {
    public int maxArea(int[] height) {
        int i = 0; 
        int j = height.length - 1;
        int maxArea = 0;

        while(i < j){
            int width = j - i;
            int length = Math.min(height[i], height[j]);
            int currArea = width * length;

            maxArea = Math.max(maxArea, currArea);
            
            if(height[i] > height[j]) j--;
            else i++;
        }

        return maxArea;
    }
}