/*
Problem: Maximum Product Subarray (LeetCode 152)

Approach:
- Traverse the array from both directions simultaneously.
- Maintain:
    1. Prefix product (left to right)
    2. Suffix product (right to left)
- Reset prefix or suffix to 1 whenever they become 0.
- At each step, update the maximum product using the
  current prefix and suffix products.
- This handles:
    • Negative numbers
    • Zeros
    • Subarrays starting or ending at any position

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {
    public int maxProduct(int[] nums) {
        int prefix=1;
        int suffix=1;
        int maxi=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            if(prefix==0) prefix=1;
            if(suffix==0) suffix=1;
            prefix*=nums[i];
            suffix*=nums[nums.length-i-1];
            maxi=Math.max(maxi,Math.max(prefix,suffix));
            

        }
        return maxi;
        
    }
}

