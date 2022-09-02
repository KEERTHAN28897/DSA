class Solution {
public:
    bool find132pattern(vector<int>& nums) {
        int n = nums.size();
      if(!n) return false;
      vector <int> minVals(n);
      minVals[0] = nums[0];
      for(int i = 1; i < n; i++){
         minVals[i] = min(minVals[i - 1], nums[i]);
      }
      stack <int> s;
      for(int i = n - 1; i > 0; i--){
         int minVal = minVals[i - 1];
         int curr = nums[i];
         while(!s.empty() && s.top() <= minVal) s.pop();
         if(!s.empty() && s.top() < curr) return true;
         s.push(nums[i]);
      }
      return false;
   }
};