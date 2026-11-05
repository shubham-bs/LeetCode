class Solution {
    List<List<Integer>> ans = new ArrayList<>();

    public String getPermutation(int n, int k) {
        int[] arr = new int[n];

        for(int i = 0; i < n; i++) arr[i] = i +1;

        permutation(
                arr,
                new ArrayList<>(),
                new boolean[n],
                k
            );

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++){
            sb.append(ans.get(k -1).get(i));
        }

        return sb.toString();
    }

    private void permutation(
        int[] arr,
        List<Integer> curr,
        boolean[] vis,
        int k
    ){
        if(curr.size() == arr.length){
            ans.add(new ArrayList<>(curr));
            k--;
            return;
        }

        for(int i = 0; i < arr.length; i++){
            if(k == 0) break;
            if(vis[i]) continue;

            curr.add(arr[i]);
            vis[i] = true;

            permutation(arr, curr, vis, k);

            curr.remove(curr.size() -1);
            vis[i] = false;

        }
    }
}