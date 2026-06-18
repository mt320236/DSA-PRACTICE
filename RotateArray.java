/*
LeetCode 189 - Rotate Array

Approach:
- Use the reverse method to perform right rotation.
- Reverse the first n-k elements.
- Reverse the last k elements.
- Reverse the complete array.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {
    public void rotate(int[] nums, int k) {
        k=k%nums.length;
        reverse(nums,0,nums.length-k-1);
        reverse(nums,nums.length-k,nums.length-1);
        reverse(nums,0,nums.length-1);

        
    }
    public void reverse(int []nums,int si,int ei){
        while(si<ei){
            int temp=nums[si];
            nums[si]=nums[ei];
            nums[ei]=temp;
            si++;
            ei--;
        }
    }
}

iska bata do github kaa scene
