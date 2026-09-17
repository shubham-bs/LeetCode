class Solution {
    public int trap(int[] height) {
        int n = height.length;

        if(n == 0) return 0;

        int l = 0, r = n -1;
        int lMax = 0, rMax = 0;
        int ans = 0;

        while(l < r){
            if(height[l] < height[r]){
                lMax = Math.max(height[l], lMax);
                ans += lMax -height[l];
                l++;
            }else{
                rMax = Math.max(height[r], rMax);
                ans += rMax -height[r];
                r--;
            }
        }

        return ans;
    }
}