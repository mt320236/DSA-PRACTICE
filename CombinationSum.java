/*
LeetCode 39 - Combination Sum

Approach:
- Use recursion with backtracking.
- At each index, we have two choices:
  1. Take the current element (if it does not exceed the remaining target).
     Since elements can be reused, stay at the same index.
  2. Skip the current element and move to the next index.
- When the target becomes 0, store a copy of the current combination.
- Backtrack by removing the last added element to explore other possibilities.

Time Complexity: O(2^T) (Exponential in the worst case)
Space Complexity: O(T) (Recursion stack excluding output)
*/

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result=new ArrayList<>();
         findPairs(0,candidates,target,result,new ArrayList <>());
         return result;
        
        
    }
    public void findPairs(int index,int  [] candidates,int target,List<List<Integer>> ans,List<Integer> ls){
        if(index==candidates.length){
            if(target==0){
                 ans.add(new ArrayList<>(ls));
                 
                
            }
            return ;
           
        }
        if(candidates[index]<=target){
            ls.add(candidates[index]);
          findPairs(index,candidates,target-candidates[index],ans,ls);
            ls.remove(ls.size()-1);

        }
        
         findPairs(index+1,candidates,target,ans,ls);
        

    }
}
