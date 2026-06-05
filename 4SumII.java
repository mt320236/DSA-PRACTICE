/*
LeetCode 454 - 4Sum II

Approach:
- Store all possible sums of nums1 and nums2 in a HashMap.
- For each sum of nums3 and nums4, find its complement in the map.
- Add the stored frequency to the answer.

Time Complexity: O(n²)
Space Complexity: O(n²)
*/


class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer,Integer> mp=new HashMap<>();
        int ans=0;

        for(int i=0;i<nums1.length;i++){
            for(int j=0;j<nums2.length;j++){
                int sum=nums1[i]+nums2[j];
                mp.put(sum,mp.getOrDefault(sum,0)+1);
                

                }


            }
            for(int i=0;i<nums3.length;i++){
            for(int j=0;j<nums4.length;j++){
                int required=-(nums3[i]+nums4[j]);
                if(mp.containsKey(required)){
                    ans+=mp.get(required);
                }
                
                

                }


            }
        
        return ans;


        
    }
}
