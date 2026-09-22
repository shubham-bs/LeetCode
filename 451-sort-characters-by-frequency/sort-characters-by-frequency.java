class Solution {
    public String frequencySort(String s) {
        int[] map = new int[128];
        for(char c: s.toCharArray()){
            map[c]++;
        }

        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> Integer.compare(b[1], a[1]));
        for(int i = 0; i < 128; i++){
            if(map[i] > 0) heap.add(new int[]{i, map[i]});
        }

        StringBuilder sb = new StringBuilder();
        while(heap.size() > 0){
            int[] top = heap.poll();
            while(top[1] > 0){
                sb.append((char) top[0]);
                top[1]--;
            }
        }

        return sb.toString();
    }
}