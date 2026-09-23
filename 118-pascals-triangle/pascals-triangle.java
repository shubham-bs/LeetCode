class Solution {
    public List<List<Integer>> generate(int numRows) {List<List<Integer>> ans = new ArrayList<>(numRows);

        for(int i = 0; i < numRows; i++){
            List<Integer> row = new ArrayList<>(i +1);
            for(int j = 0; j <= i; j++){
                row.add(1);
            }

            if(i > 0){
                List<Integer> prevRow = ans.get(i -1);
                for(int j = 1; j < i; j++) row.set(j, prevRow.get(j -1) + prevRow.get(j));
            }

            ans.add(row);
        }

        return ans;
    }
}