/*
LeetCode 2149 - Rearrange Array Elements by Sign

Approach:
- Create a new array of the same size.
- Maintain two pointers:
  - j for positive numbers (even indices)
  - k for negative numbers (odd indices)
- Traverse the array once.
- Place positive numbers at even positions and negative numbers at odd positions.
- Increment the respective pointer by 2 after each insertion.

Time Complexity: O(n)
Space Complexity: O(n)
*/

class Solution {
    public int[] rearrangeArray(int[] nums) {
        int [] newNums= new int[nums.length];
        int j=0;
        int k=1;
        
        
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0){
                newNums[j]=nums[i];
                j+=2;
            }
            else if(nums[i]<0){
                newNums[k]=nums[i];
                k+=2;
            }

        }
        return newNums;
    }
}
