class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] map = new int[128];
        int ans = 0;
        int i = 0;

        for(int j = 0; j < s.length(); j++){
            char c = s.charAt(j);
            
            i = Math.max(i, map[c]);

            ans = Math.max(ans, j -i +1);
            map[c] = j +1;
        }

        return ans;
    }
}