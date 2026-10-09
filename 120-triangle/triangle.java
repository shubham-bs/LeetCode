class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        List<Integer> dp = new ArrayList<>(triangle.get(0));

        for(int i = 1; i < triangle.size(); i++){
            List<Integer> subDp = new ArrayList<>();
            int curr;

            for(int j = 0; j < triangle.get(i).size(); j++){
                if(j == 0){
                    curr = triangle.get(i).get(j) + dp.get(j);
                }else if(j == triangle.get(i).size() - 1){
                    curr = triangle.get(i).get(j) + dp.get(j - 1);
                }else{
                    curr = triangle.get(i).get(j)
                        + Math.min(dp.get(j - 1), dp.get(j));
                }

                subDp.add(curr);
            }

            dp = subDp;
        }

        int ans = Integer.MAX_VALUE;

        for (int num : dp) {
            ans = Math.min(ans, num);
        }

        return ans;
    }
}