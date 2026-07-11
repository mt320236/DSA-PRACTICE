/*
Approach: Cyclic Sort

1. Since the array contains numbers in the range [1, n], each number has a correct index:
   Correct index = nums[i] - 1.
2. Traverse the array and place every number at its correct position using swaps.
3. If the current number is already present at its correct index (duplicate), move to the next index.
4. After cyclic sort, every index j should contain j + 1.
5. If nums[j] != j + 1, then (j + 1) is the missing number, so add it to the answer list.

Time Complexity: O(n)
Space Complexity: O(1) (excluding the output list)
*/

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int i=0;
        List<Integer> ls=new ArrayList<>();
        while(i<nums.length){
            if(nums[i]!=i+1){
                
                int index=nums[i]-1;
                if(nums[i]==nums[index]) i++;
                else{
                    int x=nums[i];
                    nums[i]=nums[index];
                    nums[index]=x;
                }
                

            }
            else{
                i++;
            }
        }
        for(int j=0;j<nums.length;j++){
            if(nums[j]!=j+1){
                ls.add(j+1);
            }
        }
        return ls;
        
    }
}
