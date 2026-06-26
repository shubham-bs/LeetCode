class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();

        for(String word: strs){
            int[] freq = new int[26];

            for(char c: word.toCharArray()){
                freq[c -'a']++;
            }

            StringBuilder key = new StringBuilder(54);

            for(int count: freq){
                key.append('#').append(count);
            }

            map.computeIfAbsent(key.toString(), k-> new ArrayList<>()).add(word);
        }

        return new ArrayList<>(map.values());

    }
}