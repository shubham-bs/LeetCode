class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int l = s.length();
        int minLen = Integer.MAX_VALUE;
        int count = 0;

        int i = 0;
        String ans = "";
        for(int j = 0; j < l; j++){
            if(s.charAt(j) == '1') count++;

            while(count == k){

                while (i < j && s.charAt(i) == '0') {
                    i++;
                }
                int currLen = j -i +1;

                if(currLen < minLen){
                    minLen = currLen;
                    ans = s.substring(i, j +1);
                }else if(currLen == minLen){
                    String candidate = s.substring(i, j +1);

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

                count--;
                i++;
            }  
        }

        return ans;
    }
}