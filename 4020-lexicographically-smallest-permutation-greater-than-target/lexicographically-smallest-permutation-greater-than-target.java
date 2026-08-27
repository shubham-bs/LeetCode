class Solution {
    public String lexGreaterPermutation(String s, String target) {
        int[] f1 = new int[26];

        int n = s.length();
        for(int i = 0; i < n ;i++){
            f1[s.charAt(i) - 'a']++;
        }

        int matchLen = 0;
        while(matchLen < n){
            int idx = target.charAt(matchLen) - 'a';
            if(f1[idx] > 0){
                f1[idx]--;
                matchLen++;
            }else break;
        }

        for (int i = matchLen; i >= 0; i--) {
            if (i < matchLen) {
                f1[target.charAt(i) - 'a']++;
            }
            
            if (i == n) continue; 

            int targetCharIdx = target.charAt(i) - 'a';
            
            for (int c = targetCharIdx + 1; c < 26; c++) {
                if (f1[c] > 0) {
                    StringBuilder sb = new StringBuilder();
                    
                    sb.append(target.substring(0, i));
                    
                    sb.append((char) ('a' + c));
                    f1[c]--;
                    
                    for (int j = 0; j < 26; j++) {
                        while (f1[j] > 0) {
                            sb.append((char) ('a' + j));
                            f1[j]--;
                        }
                    }
                    return sb.toString();
                }
            }
        }

        return "";
    }
}