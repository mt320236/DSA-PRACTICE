/*
LeetCode 35 - Search Insert Position

Approach:
- Use Binary Search to find the target.
- If target is found, return its index.
- If not found, the left pointer (s) will indicate the correct insertion position.

Time Complexity: O(log n)
Space Complexity: O(1)
*/


class Solution {
    public int searchInsert(int[] nums, int target) {
        int s=0;
        int l=nums.length-1;
        int mid=(s+l)/2;
    while(s<=l){
        
         mid=(s+l)/2;
         
        if (nums[mid]==target) return mid;
        if(nums[mid]>target){
            l=mid-1;
            
        }
        if(nums[mid]<target){
            s=mid+1;
        }
        
     }
     return s;

        
    }
}
