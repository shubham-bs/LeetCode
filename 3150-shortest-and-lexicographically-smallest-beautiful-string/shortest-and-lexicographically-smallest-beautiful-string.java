class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int l = s.length();

        int onesCount = 0;
        for (int j = 0; j < l; j++) {
            if (s.charAt(j) == '1') {
                onesCount++;
            }
        }
        
        if (onesCount < k) {
            return "";
        }
        
        int[] onesPos = new int[onesCount];
        int idx = 0;
        for (int j = 0; j < l; j++) {
            if (s.charAt(j) == '1') {
                onesPos[idx++] = j;
            }
        }
        
        int minLen = Integer.MAX_VALUE;
        String ans = "";
        
        for (int i = 0; i <= onesCount - k; i++) {
            int startIdx = onesPos[i];
            int endIdx = onesPos[i + k - 1];
            int currLen = endIdx - startIdx + 1;
            
            if (currLen < minLen) {
                minLen = currLen;
                ans = s.substring(startIdx, endIdx + 1);
            } else if (currLen == minLen) {
                String candidate = s.substring(startIdx, endIdx + 1);
                
                for (int x = 0; x < currLen; x++) {
                    char c1 = candidate.charAt(x);
                    char c2 = ans.charAt(x);
                    
                    if (c1 != c2) {
                        if (c1 < c2) {
                            ans = candidate;
                        }
                        break;
                    }
                }
            }
        }
        
        return ans;
    }
}
