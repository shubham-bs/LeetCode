class Solution {
    public int numJewelsInStones(String jewels, String stones) {

        HashMap<Character, Integer> ston = new HashMap<>();
        int ans = 0;
        for(char c: stones.toCharArray()){
            ston.put(c, ston.getOrDefault(c, 0) +1);
        }
        
        for(char c: jewels.toCharArray()){
            ans += ston.getOrDefault(c, 0);
        }

        return ans;
    }
}