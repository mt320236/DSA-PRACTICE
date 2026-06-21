/*
Problem: Lower Bound

Approach:
- Use Binary Search to find the first index where the element is greater than or equal to x.
- If nums[mid] >= x, store mid as a potential answer and search in the left half.
- Otherwise, search in the right half.
- If no such element exists, return nums.length.

Time Complexity: O(log n)
Space Complexity: O(1)
*/

class Solution {
    public int lowerBound(int[] nums, int x) {
        return search(nums,x,0,nums.length-1);


       
     }
     public int search(int [] nums,int x,int low,int high){
        int ans=nums.length;
        
        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid]>=x){
                ans=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return ans;
     }
}
