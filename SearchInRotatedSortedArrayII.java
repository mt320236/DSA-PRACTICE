/*
LeetCode 81 - Search in Rotated Sorted Array II

Approach:
- Use Binary Search to search for the target.
- Handle duplicate elements by shrinking the search space when
  nums[low] == nums[mid] == nums[high].
- Identify whether the left half or right half is sorted.
- If the target lies in the sorted half, continue searching there.
- Otherwise, search in the other half.

Time Complexity: O(log n) on average, O(n) in the worst case due to duplicates.
Space Complexity: O(1)
*/

class Solution {
    public boolean search(int[] nums, int target) {
        return search(nums,target,0,nums.length-1);
        
    }
    public boolean search(int [] nums,int target,int low,int high){
        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid]==target){
                return true;
            }
            if(nums[low]==nums[mid] && nums[mid]==nums[high]){
                low++;
                high--;
                continue;
            }
            if(nums[low]<=nums[mid]){
                if(nums[low]<=target  && target<nums[mid]){
                    high=mid-1;
                }
                else{
                    low=mid+1;
                }
            }
            else{
                if(nums[mid]<target && target<=nums[high]){
                    low=mid+1;
                }
                else{
                    high=mid-1;
                }
            }
        }
        return false;
    }
}
