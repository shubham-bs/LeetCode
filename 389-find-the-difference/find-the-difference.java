class Solution {
    public char findTheDifference(String s, String t) {
        char ans = 0;

        for(char S: s.toCharArray()){
            ans ^= S;
        }

        for(char T: t.toCharArray()){
            ans ^= T;
        }

        return (char) ans;
    }
}