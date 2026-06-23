/*
Problem: Find K Rotation

Approach:
- Use Binary Search to locate the minimum element in the rotated sorted array.
- Track both the minimum value and its index.
- If nums[mid] > nums[high], the minimum lies in the right half.
- Otherwise, search in the left half.
- The index of the minimum element represents the number of rotations.

Time Complexity: O(log n)
Space Complexity: O(1)
*/

class Solution {
    public int findKRotation(ArrayList<Integer> nums) {
       return search(nums,0,nums.size()-1);

    
    }
    public int search(ArrayList<Integer> nums,int low, int high){
    int minimum=nums.get(0);
    int minIndex=0;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums.get(mid)<minimum){
                minimum=nums.get(mid);
                minIndex=mid;
            }
            
            if(nums.get(mid)>nums.get(high)){
                low=mid+1;
            }
            else{
                high=mid-1;
            }

        }
        return minIndex;
    }
}
