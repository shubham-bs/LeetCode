class Solution {
    public int maximumLengthSubstring(String s) {
        int[] freq = new int[26];
        int i = 0, j = 0, ans = 0;

        while(j < s.length()){
            int idx = s.charAt(j) - 'a';

            while(freq[idx] >= 2){
                freq[s.charAt(i) - 'a']--;
                i++;
            }
            
            freq[idx]++;
            ans = Math.max(ans, j - i +1);
            j++;
        }

        return ans;
    }
}