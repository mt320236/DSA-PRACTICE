/*
Topic - Binary Search
LeetCode 540 - Single Element in a Sorted Array

Approach:
- Use Binary Search to find the single non-duplicate element.
- Handle edge cases:
  - Array contains only one element.
  - First element is unique.
  - Last element is unique.
- For the remaining elements:
  - Check if nums[mid] is different from both neighbors.
  - Use index parity (even/odd) to determine which half contains the single element.
  - Before the single element, pairs start at even indices.
  - After the single element, the pairing pattern breaks.
- Reduce the search space until the unique element is found.

Time Complexity: O(log n)
Space Complexity: O(1)
*/

class Solution {
    public int singleNonDuplicate(int[] nums) {
        return search(nums,0,nums.length-1);
        
    }
    public int search(int [] nums,int low,int high){
        if(nums.length==1) return nums[0];
        if(nums[0]!=nums[1]) return nums[0];
        if(nums[nums.length-1]!=nums[nums.length-2]) return nums[nums.length-1];
        low=1;
        high=nums.length-2;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid]!=nums[mid-1] && nums[mid]!=nums[mid+1]) return nums[mid];
            else if((mid%2==0 && nums[mid]==nums[mid+1]) || (mid%2!=0 && nums[mid-1]==nums[mid])){
                low=mid+1;
            }
            else{
                high=mid-1;
            }

        }







        return -1;

    }
}
