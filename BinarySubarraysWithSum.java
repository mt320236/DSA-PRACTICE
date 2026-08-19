/*
LeetCode 930 - Binary Subarrays With Sum

Approach:
- Use the sliding window technique to calculate the number of subarrays
  having sum at most a given value.
- The number of subarrays with sum exactly equal to goal is:
  
  atMost(goal) - atMost(goal - 1)

- Maintain a window using two pointers (l and r).
- Expand the window by moving r.
- If the sum becomes greater than goal, move l forward until
  the sum becomes valid again.
- For every r, there are (r - l + 1) valid subarrays ending at r.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return atMost(nums, goal) - atMost(nums, goal - 1);
    }

    public int atMost(int[] nums, int goal) {
        if (goal < 0) return 0;

        int l = 0;
        int total = 0;
        int sum = 0;

        for (int r = 0; r < nums.length; r++) {
            sum += nums[r];

            while (sum > goal) {
                sum -= nums[l];
                l++;
            }

            total += r - l + 1;
        }

        return total;
    }
}
