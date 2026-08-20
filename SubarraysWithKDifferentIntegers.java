/*
LeetCode 992 - Subarrays with K Different Integers

Approach:
- Use the sliding window technique to count subarrays with at most K
  distinct integers.
- Maintain the frequency of each integer in a HashMap.
- If the number of distinct integers becomes greater than K, shrink
  the window from the left.
- For every right pointer r, (r - l + 1) gives the number of valid
  subarrays ending at r.
- The number of subarrays with exactly K distinct integers is:

  atMost(K) - atMost(K - 1)

Time Complexity: O(n) average
Space Complexity: O(k)
*/

class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        int ans=findValue(nums,k)-findValue(nums,k-1);
        return ans;
    }
        public int findValue(int [] nums,int k){
            if(k<0) return 0;
            int l=0;
        int r=0;
        int cnt=0;
        Map<Integer,Integer> mpp=new HashMap<>();
        while(r<nums.length){
            mpp.put(nums[r],mpp.getOrDefault(nums[r],0)+1);
            while(mpp.size()>k){
                mpp.put(nums[l],mpp.get(nums[l])-1);
                if(mpp.get(nums[l])==0) mpp.remove(nums[l]);
                l++;
            }
            cnt+=r-l+1;
            r++;

        }
        return cnt;

        
        

        
    }
}
