/*
LeetCode 78 - Subsets

Approach:
- Use recursion and backtracking.
- For each element, make two choices:
  1. Include the current element.
  2. Exclude the current element.
- When all elements are processed, add the current subset to the answer.

*/

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        result(nums,0,ans,new ArrayList<>());
        return ans;
        
    }
    public void result(int [] nums , int index,List<List<Integer>> ans,List<Integer> ls){
        if(index==nums.length){
            ans.add(new ArrayList<>(ls));
            return;
        }
        ls.add(nums[index]);
        result(nums,index+1,ans,ls);
        ls.remove(ls.size()-1);
        result(nums,index+1,ans ,ls);

        
    }
}
