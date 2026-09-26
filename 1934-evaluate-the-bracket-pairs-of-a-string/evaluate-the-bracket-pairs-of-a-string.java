class Solution {
    public String evaluate(String s, List<List<String>> knowledge) { 
        Map<String, String> map = new HashMap<>(knowledge.size());

        for(List<String> pair: knowledge){
            map.put(pair.get(0), pair.get(1));
        }

        StringBuilder sb = new StringBuilder();
        int n = s.length();
        int i = 0;
        
        while(i < n){
            int start = s.indexOf('(', i);

            if(start == -1){
                sb.append(s, i, n);
                break;
            }

            sb.append(s, i, start);

            int end = s.indexOf(')', start);

            String key = s.substring(start +1, end);
            sb.append(map.getOrDefault(key, "?"));

            i = end +1;
        }

        return sb.toString();
    }
}