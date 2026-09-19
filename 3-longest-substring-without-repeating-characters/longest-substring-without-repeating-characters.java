class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] map = new int[128];
        int ans = 0;
        int i = 0;

        for(int j = 0; j < s.length(); j++){
            char c = s.charAt(j);
            map[c]++;

            while(map[c] > 1){
                map[s.charAt(i)]--;
                i++;
            }

            ans = Math.max(ans, j -i +1);
        }

        return ans;
    }
}