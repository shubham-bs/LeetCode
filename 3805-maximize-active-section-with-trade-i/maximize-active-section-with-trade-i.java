class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        int ones = 0;
        for(char c: s.toCharArray()){
            if(c == '1') ones++;
        }

        String t = "1" + s + "1";
        int ans = ones;

        int prevPrevLen = 0;
        int prevLen = 0;
        char prevPrevChar = '#';
        char prevChar = '#';

        int i = 0;

        while(i < t.length()){
            char currChar = t.charAt(i);
            int j = i;

            while(j < t.length() && t.charAt(j) == currChar){
                j++;
            }

            int currLen = j -i;

            if(prevPrevChar == '0' && prevChar == '1' && currChar == '0'){
                ans = Math.max(ans, ones + prevPrevLen + currLen);
            }

            prevPrevChar = prevChar;
            prevPrevLen = prevLen;

            prevChar = currChar;
            prevLen = currLen;

            i = j;
        }

        return ans;

    }
}