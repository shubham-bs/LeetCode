class Solution {
    public int beautySum(String s) {
        int n = s.length();
        int ans = 0;

        for(int i = 0; i < n; i++){

            int[] freq = new int[26];

            for(int j = i; j < n; j++){
                char c = s.charAt(j);
                freq[c - 'a']++;

                int max = 0, min = 501;
                for(int f: freq){
                    max = Math.max(max, f);
                    if(f == 0) continue;
                    min = Math.min(min, f);
                }

                ans += max - min;
            }
        }

        return ans;
    }
}