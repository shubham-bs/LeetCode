class Solution {
    public boolean isAnagram(String s, String t) {
        int[] sfreq = new int[26];

        for(char c: s.toCharArray()){
            sfreq[c -'a']++;
        }

        for(char c: t.toCharArray()){
            sfreq[c -'a']--;
        }

        for(int i: sfreq){
            if(i != 0){
                return false;
            }
        }

        return true;
        
    }
}