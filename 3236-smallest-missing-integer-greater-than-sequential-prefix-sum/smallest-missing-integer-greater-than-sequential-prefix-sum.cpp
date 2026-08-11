class Solution {
public:
    int missingInteger(vector<int>& nums) {
        int sum = nums[0];
        int size = nums.size();
        int i;
        unordered_set<int> my_set(nums.begin(), nums.end());
        for(i = 1; i < size; i++){
            if(nums[i] == nums[i-1]+1){
                sum += nums[i];
            }
            else break;
        }
        cout << sum << endl;
        while(true){
            if(my_set.contains(sum)){
                sum++;
            }
            else{
                return sum;
            }
        }
        return sum;
    }
};