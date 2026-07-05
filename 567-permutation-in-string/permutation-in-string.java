class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length();
        if(n > s2.length()){
            return false;
        }

        int[] s1f = new int[26];
        int[] s2f = new int[26];

        for(int i = 0; i < n; i++){
            s1f[s1.charAt(i) - 'a']++;
            s2f[s2.charAt(i) - 'a']++;
        }

        int l = 0;
        while(l + n < s2.length()){

            if(matches(s1f, s2f)){
                return true;
            }

            s2f[s2.charAt(l) - 'a']--;
            l++;
            s2f[s2.charAt(l +n -1) - 'a']++;
        }

        return matches(s1f, s2f);
    }

    private boolean matches(int[] a, int[] b){
        for(int i = 0; i < 26; i++){
            if(a[i] != b[i]){
                return false;
                }
        }
        return true;
    }
}