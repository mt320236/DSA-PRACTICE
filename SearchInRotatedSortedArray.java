/*
LeetCode 33 - Search in Rotated Sorted Array

Approach:
- Use Binary Search to find the target.
- In each iteration, identify whether the left half or right half is sorted.
- If the target lies within the sorted half, search there.
- Otherwise, search in the other half.
- Continue until the target is found or the search space becomes empty.

Time Complexity: O(log n)
Space Complexity: O(1)
*/

class Solution {
    public int search(int[] nums, int target) {
      return  search(nums,target,0,nums.length-1);

        
    }
    public int search(int [] nums,int target,int low,int high){
        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid]==target){
                return mid;
            }
            else if(nums[mid]>=nums[low]){
                if(nums[low]<=target && target< nums[mid]){
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
            
        return -1;
    }
}
