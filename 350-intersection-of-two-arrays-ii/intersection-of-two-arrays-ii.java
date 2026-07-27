class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length){
            return intersect(nums2, nums1);
        }

        List<Integer> ans = new ArrayList<>();

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int num: nums1){
            map.put(num, map.getOrDefault(num, 0) +1);
        }

        for(int num: nums2){
            Integer count = map.get(num);

            if(count != null && count > 0){
                ans.add(num);
                map.put(num, count -1);
            }
        }

        int[] res = new int[ans.size()];

        for(int i = 0; i < ans.size(); i++){
            res[i] = ans.get(i);
        }

        return res;
    }
}