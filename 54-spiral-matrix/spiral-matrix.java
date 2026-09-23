class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int m = matrix[0].length;
        int n = matrix.length;

        int rS = 0;
        int rE = n -1;
        int cS = 0;
        int cE = m -1;

        while(rS <= rE && cS <= cE){
            for(int i = cS; i <= cE; i++) ans.add(matrix[rS][i]);
            rS++;

            for(int i = rS; i <= rE; i++) ans.add(matrix[i][cE]);
            cE--;

            if(rS <= rE){
                for(int i = cE; i >= cS; i--) ans.add(matrix[rE][i]);
                rE--;
            }

            if(cS <= cE){
                for(int i = rE; i >= rS; i--) ans.add(matrix[i][cS]);
                cS++;
            }
        }

        return ans;
    }
}