class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        HashMap<String, String> map = new HashMap<>();

        for(int k = 0; k < knowledge.size(); k++){
            map.put(knowledge.get(k).get(0), knowledge.get(k).get(1));
        }
        
        while(i < s.length()){
            char c = s.charAt(i);

            if(c == '('){
                int j = i +1;
                StringBuilder sbKey = new StringBuilder();

                while(s.charAt(j) != ')'){
                    sbKey.append(s.charAt(j));
                    j++;
                }

                String key = sbKey.toString();
                sb.append(map.getOrDefault(key, "?"));

                i = j +1;
            }else{
                sb.append(c);
                i++;
            }
        }

        return sb.toString();
    }
}