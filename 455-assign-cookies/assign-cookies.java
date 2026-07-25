class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int ans = 0;
        int gLen = g.length;
        int sLen = s.length;

        Arrays.sort(g);
        Arrays.sort(s);

        int i = 0;
        int j = 0;

        while(i < gLen && j < sLen){
            if(s[j] >= g[i]){
                ans++;
                i++;
            }
            j++;
        }
        return ans;
    }
}