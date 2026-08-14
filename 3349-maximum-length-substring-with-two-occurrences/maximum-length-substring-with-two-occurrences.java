class Solution {
    public int maximumLengthSubstring(String s) {
        int[] freq = new int[26];
        int ans = 0;
        int i = 0, j = 0;
        int currLen = 0;

        while(j < s.length()){
            int idx = s.charAt(j) - 'a';

            
            while(freq[idx] >= 2){
                freq[s.charAt(i) - 'a']--;
                i++;
                currLen--;
            }
            

            freq[idx]++;
            j++;
            currLen++;
            ans = Math.max(ans, currLen);
        }

        return ans;
    }
}