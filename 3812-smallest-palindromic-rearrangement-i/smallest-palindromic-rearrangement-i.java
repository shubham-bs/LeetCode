class Solution {
    public String smallestPalindrome(String s) {
        int[] freq = new int[26];
        int n = s.length();

        for(int i = 0; i < n; i++){
            freq[s.charAt(i) - 'a']++;
        }

        char[] pal = new char[n];
        int i = 0;
        int j = n -1;

        for(int k = 0; k < 26; k++){
            char c = (char)(k + 'a');
            while(freq[k] >= 2){
                pal[i++] = c;
                pal[j--] = c;
                freq[k] -= 2;
            }
        }

        for(int k = 0; k < 26; k++){
            if(freq[k] == 1){
                pal[i] = (char)(k + 'a');
                break;
            }
        }

        return new String(pal);
    }
}