/*
Topic - Binary Search
LeetCode 410 - Split Array Largest Sum

Approach:
- Use Binary Search on the maximum possible subarray sum.
- The minimum possible value is the largest element in the array,
  and the maximum possible value is the sum of all elements.
- For each candidate value, greedily split the array into the minimum
  number of subarrays such that each subarray sum does not exceed the candidate value.
- If the required number of subarrays is within k, try a smaller maximum sum.
- Otherwise, increase the maximum allowed sum.
- Return the minimum possible largest subarray sum.

Time Complexity: O(n * log(sumOfArray))
Space Complexity: O(1)
*/


class Solution {
    public int splitArray(int[] nums, int k) {
        return search(nums,k,findLow(nums),findHigh(nums));
        
    }
    public int findLow(int [] nums){
        int maxEl=nums[0];
        for(int e: nums){
            maxEl=Math.max(maxEl,e);

        }
        return maxEl;
    }
    public int findHigh(int [] nums){
        int sum=0;
        for(int e:nums){
            sum+=e;
        }
        return sum;
    }
    public int search(int [] nums,int k, int low,int high){
        while(low<=high){
            int mid=low+(high-low)/2;
            int no=findSum(nums,mid);
            if(no<=k){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return low;
    }
    public int findSum(int [] nums,int mid){
        int k=1; int sum=0;
        for(int i=0;i<nums.length;i++){
            if(sum+nums[i]<=mid){
                sum+=nums[i];
            }
            else{
                k++;
                sum=nums[i];
            }
        }
        return k;
    }
}
