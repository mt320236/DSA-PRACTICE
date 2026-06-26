/*
Aggressive Cows

Approach:
- Sort the stall positions.
- Use Binary Search on the minimum possible distance between two cows.
- For each candidate distance, greedily place cows in the stalls.
- If at least k cows can be placed, try to maximize the minimum distance.
- Otherwise, reduce the distance.
- The largest valid minimum distance is the answer.

Time Complexity: O(n log n + n * log(maxDistance))
Space Complexity: O(1)
*/

class Solution {
    public int aggressiveCows(int[] nums, int k) {
        Arrays.sort(nums);
        return search(nums,k,1,nums[nums.length-1]-nums[0]);
   
    }
    public int search(int [] nums,int k,int low,int high){
        while(low<=high){
            int mid=low+(high-low)/2;
            int result=canWe(nums,mid);
            if(result>=k){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return high;

    }
    public int canWe(int [] nums,int mid){
        int cnt=1;int lastCow=nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i]-lastCow>=mid){
                
                cnt++;
                lastCow=nums[i];
            }

        }
        return cnt;

    }
}
