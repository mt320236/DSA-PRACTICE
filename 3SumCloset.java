/*
LeetCode 16 - 3Sum Closest

Approach:
- Sort the array.
- Fix one element and use two pointers to find the closest triplet sum.
- Update the nearest sum whenever a closer sum is found.
- Move pointers based on comparison with the target.

Time Complexity: O(n²)
Space Complexity: O(1)
*/



class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int nearestSum=nums[0]+nums[1]+nums[2];
        
        for(int i=0;i<nums.length-2;i++){
            int j= i+1;
            int k=nums.length-1;
            
            
            while(j<k){
                
                int sum=nums[i]+nums[j]+nums[k];
                 if(Math.abs(nearestSum-target)>Math.abs(sum-target)){
                nearestSum=sum;
             }
              if(sum>target){
                k--;
             }
              else if(sum<target){
                j++;

             }
             else{
                return sum;
             }
             
            
             
            }



        }
        return nearestSum;
    }
}
