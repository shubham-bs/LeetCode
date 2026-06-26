class Solution {
    public int trap(int[] height) {
        int l =0;
        int r= height.length -1;
        int water = 0;
        int lMaxH = 0;
        int rMaxH = 0;

        while(l < r){
            if(height[l] < height[r]){
                lMaxH = Math.max(height[l], lMaxH);
                water += lMaxH - height[l];
                l++;
            }else{
                rMaxH = Math.max(height[r], rMaxH);
                water += rMaxH - height[r];
                r--;
            }
        }

        return water;
        
    }
}