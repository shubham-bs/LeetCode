class Solution {
    public int strStr(String haystack, String needle) {
        int n = needle.length();
        int h = haystack.length();

        if(n > h) return -1;

        for(int i = 0; i < h; i++){
            if(haystack.charAt(i) == needle.charAt(0) && i + n <= h){
                String sub = haystack.substring(i , i +n);
                if(sub.equals(needle)) return i;
            }
        }

        return -1;
    }
}