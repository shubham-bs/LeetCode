class Solution {
    public int longestPalindrome(String s) {
        int[] freq = new int[52];
        int n = s.length();

        for(char c: s.toCharArray()){
            freq[c >= 'a' ? c -'a' : c -'A' +26]++;
        }

        int ans = 0;
        for(int f: freq){
            ans += (f /2) * 2;
        }

        return ans < n ? ans +1 : ans;
    }
}