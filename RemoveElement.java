/*
LeetCode 27 - Remove Element

Approach:
- Use two pointers.
- One pointer traverses the array.
- The other pointer keeps track of the position for the next valid element.
- Copy all elements that are not equal to the target value.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {
    public int removeElement(int[] nums, int val) {
        int j=0;
        for(int i=0; i<nums.length;i++){
            if(nums[i]!=val){
                nums[j]=nums[i];
                j++;
            }
        }
        return j;
        
    }
}
