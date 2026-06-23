/*
LeetCode 153 - Find Minimum in Rotated Sorted Array

Approach:
- Use Binary Search to reduce the search space.
- Track the minimum value encountered during the search.
- If nums[mid] > nums[high], the minimum lies in the right half.
- Otherwise, the minimum lies in the left half (including mid).
- Update the minimum using nums[mid] in every iteration.

Time Complexity: O(log n)
Space Complexity: O(1)
*/

class Solution {
    public int findMin(int[] nums) {
        return search(nums,0,nums.length-1);
        

    }
    public int search(int [] nums,int low, int high){
    int minimum=nums[0];
        while(low<=high){
            int mid=low+(high-low)/2;
            minimum=Math.min(minimum,nums[mid]);
            if(nums[mid]>nums[high]){
                low=mid+1;
            }
            else{
                high=mid-1;
            }

        }
        return minimum;
    }
}
