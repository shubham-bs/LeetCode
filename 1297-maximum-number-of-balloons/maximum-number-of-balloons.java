class Solution {
    public int maxNumberOfBalloons(String text) {
        int[] freq = new int[26];

        for(char c: text.toCharArray()){
            freq[c -'a']++;
        }

        int ans = 0;

        while(freq['a' -'a'] >0 && freq['b' -'a'] >0 &&freq['n' -'a'] >0 &&freq['l' -'a'] >1 && freq['o' -'a'] >1){
            freq['b' -'a']--;
            freq['a' -'a']--;
            freq['l' -'a'] = freq['l' -'a'] -2;
            freq['o' -'a'] = freq['o' -'a'] -2;
            freq['n' -'a']--;
            ans++;
        }

        return ans;
        
    }
}