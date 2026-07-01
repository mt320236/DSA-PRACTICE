/*
LeetCode 40 - Combination Sum II

Approach:
- Sort the array to handle duplicates efficiently.
- Use backtracking to generate all possible combinations.
- Skip duplicate elements at the same recursion level to avoid duplicate combinations.
- If the current element is greater than the remaining target, stop exploring further since the array is sorted.
- Move to the next index (i + 1) after choosing an element because each number can be used only once.

Time Complexity: O(2^n) (Worst Case)
Space Complexity: O(n) (Recursion stack excluding output)
*/

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans=new ArrayList<>();
        result(candidates,target,0,ans,new ArrayList<>());
        return ans;
        
    }
    public void result(int [] nums,int target,int index,List<List<Integer>> ans,List<Integer> ls){
        if(target==0){
            ans.add(new ArrayList<>(ls));
            return;
        }
        for(int i=index;i<nums.length;i++){
            if(i>index && nums[i]==nums[i-1]) continue;
            if(nums[i]>target) break;
            ls.add(nums[i]);
            result(nums,target-nums[i],i+1,ans,ls);
            ls.remove(ls.size()-1);

        }

    }
}
