/*
Problem: Next Permutation (LeetCode 31)

Approach:
1. Traverse from right to left and find the first index
   where nums[i] < nums[i + 1]. This is the breakpoint.
2. If no breakpoint exists, the array is in descending order.
   Reverse the entire array to get the smallest permutation.
3. Otherwise, find the first element from the right that is
   greater than nums[breakpoint].
4. Swap the breakpoint element with that element.
5. Reverse the suffix (elements after the breakpoint) to get
   the next lexicographically greater permutation.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {
    public void nextPermutation(int[] nums) {
        int ind=-1;
        
        for(int i=nums.length-2;i>=0;i--){
            
            
            if(nums[i]<nums[i+1]){
                ind=i;
                break;


            }
        }
        if(ind==-1){
            int j=nums.length-1;
            int k=ind+1;
             while(j>k){
            int temp=nums[j];
            nums[j]=nums[k];
            nums[k]=temp;
            j--;
            k++;

        }
        return;

        }
        
        int minIndex=nums.length-1;
        for(int i=nums.length-1;i>ind;i--){
            if(nums[i]>nums[ind]){
                minIndex=i;
                break;

            }
        }
        int temp=nums[ind];
        nums[ind]=nums[minIndex];
        nums[minIndex]=temp;
        int i =nums.length-1;
        int j=ind+1;
        while(i>j){
            int k=nums[i];
            nums[i]=nums[j];
            nums[j]=k;
            i--;
            j++;

        }
        
        
        
    }
}
