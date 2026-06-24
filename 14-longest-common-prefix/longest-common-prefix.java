class Solution {
    private TrieNode root = new TrieNode();

    public void insert(String word){
        TrieNode curr = root;
        for(char c: word.toCharArray()){
            int index = c -'a';;
            if(curr.children[index] == null){
                curr.children[index] = new TrieNode();
            }
            curr = curr.children[index];
        }
        curr.isEnd = true;
    }

    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0){
            return "";
        }

        for(String word: strs){
            insert(word);
        }

        // Build Trie
        StringBuilder prefix = new StringBuilder();
        TrieNode curr = root;
        while(true){
            int childCount = 0;
            int childIndex = -1;
            for(int i =0; i < 26; i++){
                if(curr.children[i] != null){
                    childCount++;
                    childIndex = i;
                }
            }

            if(childCount != 1 || curr.isEnd){
            break;
            }

            prefix.append((char)('a' + childIndex));
            curr = curr.children[childIndex];
        }
        return prefix.toString();
    }
}

class TrieNode{

    TrieNode[] children = new TrieNode[26];
    boolean isEnd;
}