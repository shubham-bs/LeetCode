class Solution {
    public int mySqrt(int x) {
        int l = 0;
        int h = x;

        while(l <= h){
            int mid = l + (h -l) / 2;

            long sq = (long) mid * mid;
            if(sq== x) return mid;
            else if(sq > x) h = mid -1;
            else l = mid + 1;
        }

        return l -1;
    }
}