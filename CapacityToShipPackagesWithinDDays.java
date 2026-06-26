/*
Topic - Binary Search
LeetCode 1011 - Capacity To Ship Packages Within D Days

Approach:
- Use Binary Search on the ship's capacity.
- The minimum possible capacity is the maximum weight in the array,
  and the maximum possible capacity is the sum of all weights.
- For each candidate capacity, simulate the shipping process and
  count the number of days required.
- If the required days are within the given limit, try a smaller capacity.
- Otherwise, increase the capacity.
- The minimum valid capacity is the answer.

Time Complexity: O(n * log(sumOfWeights))
Space Complexity: O(1)
*/

class Solution {
    public int shipWithinDays(int[] weights, int days) {
       return findWeight(weights,days,findLow(weights),findRange(weights));
        
    }
    public int findLow(int [] nums){
        int maxEl=nums[0];
        for(int e:nums){
            maxEl=Math.max(maxEl,e);
        }
        return maxEl;
    }
    public int findRange(int [] nums){
        int sum=0;
        for(int e:nums){
            sum+=e;

        }
        return sum;

    }
    public int findWeight(int [] nums,int days,int low,int high){
        int result=high;
        while(low<=high){
            int mid=low+(high-low)/2;
            int d=calcResult(nums,mid);
            if(d<=days){
                result=mid;
                high=mid-1;

            }
            else{
                low=mid+1;
            }

        }
        return result;

    }
    public int calcResult(int [] nums,int mid){
        long sum=0;
        int d=1;
        for(int e:nums){
            
            if(sum+e>mid ){
                sum=e;
                d++;
            }
            else{
                sum+=e;
            }
            
        }
        return d;

    }
}
