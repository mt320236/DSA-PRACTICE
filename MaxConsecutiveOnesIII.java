/*
LeetCode 1004 - Max Consecutive Ones III

Approach:
1. Maintain a sliding window using left and right pointers.
2. Count the number of zeros inside the window.
3. If the number of zeros exceeds k, move the left pointer forward
   and reduce the zero count when a zero is removed.
4. Track the maximum valid window length.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {
    public int longestOnes(int[] nums, int k) {
        int left = 0;
        int zeroCount = 0;
        int maxLen = 0;

        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) {
                zeroCount++;
            }

            if (zeroCount > k) {
                if (nums[left] == 0) {
                    zeroCount--;
                }
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}
