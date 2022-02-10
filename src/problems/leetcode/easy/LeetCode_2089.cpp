class Solution {
public:
   static vector<int> targetIndices(vector<int> &nums, int target) {
      vector<int> result;
      std::sort(nums.begin(), nums.end());
      for (int index = 0; index < nums.size(); index++) {
         if (nums[index] == target) {
            result.push_back(index);
         }
      }
      return result;
   }
};