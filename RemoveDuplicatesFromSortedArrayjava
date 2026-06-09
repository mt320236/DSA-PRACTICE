/*
LeetCode 26 - Remove Duplicates from Sorted Array

Approach:
- Since the array is sorted, duplicates appear consecutively.
- Use two pointers:
  - One pointer traverses the array.
  - The other pointer tracks the position of the next unique element.
- Copy unique elements in-place and return the count of unique elements.

Time Complexity: O(n)
Space Complexity: O(1)
*/


class Solution {
    public int removeDuplicates(int[] nums) {
       if(nums.length==0){
            return 0;
        }

        int j=1;
       
        
        for(int i=1; i<nums.length;i++){

            if( nums[i]!=nums[i-1]){
                nums[j]=nums[i];
                j++;
                

            }
        }
        return j;

        
    }
}
