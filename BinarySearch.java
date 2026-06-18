/*
LeetCode 704 - Binary Search

Approach:
- Maintain two pointers: low and high.
- Find the middle element.
- If target is greater, search in the right half.
- If target is smaller, search in the left half.
- Continue until target is found or search space becomes empty.

Time Complexity: O(log n)
Space Complexity: O(1)
*/

class Solution {
    public int search(int[] nums, int target) {
        return binarySearch(nums,target,0,nums.length-1);
    }

    public int binarySearch(int [] nums,int target,int low,int high){

        while(low<=high){
            int mid=low+(high-low)/2;

            if(target==nums[mid]) return mid;

            else if(target>nums[mid]){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }

        return -1;
    }
}
