class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] freq = new int[128];
        int l = 0;
        int r = 0;
        int max = 0;

        while(r < s.length()){
            freq[128 - s.charAt(r)]++;

            while(freq[128 -s.charAt(r)] > 1){
                freq[128 -s.charAt(l)]--;
                l++;
            }
            max = Math.max(max, r -l +1);
            r++;
        }
        return max;
    }
}