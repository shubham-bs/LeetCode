class Solution {
    public int longestPalindrome(String s) {
        int[] freq = new int[52];
        int n = s.length();

        for(char c: s.toCharArray()){
            if(Character.isLowerCase(c)){
                freq[c -'a']++;
            }else{
                freq[c -'A' +26]++;
            }
        }

        int ans = 0;
        for(int f: freq){
            if(f % 2 == 0){
                ans += f;
            }else{
                ans += f -1;
            }
        }

        if(ans < n){
            return ans +1;
        }

        return ans;
    }
}