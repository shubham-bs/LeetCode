class Solution {
    public int longestPalindrome(String s) {
        int[] freq = new int[52];
        int n = s.length();

        for(char c: s.toCharArray()){
            freq[c >= 'a' ? c -'a' : c -'A' +26]++;
        }

        int ans = 0;
        boolean hasOdd = false;
        for(int f: freq){
            ans += (f /2) * 2;
            if(f % 2 == 1){
                hasOdd = true;
            }
        }

        return hasOdd? ans +1: ans;
    }
}