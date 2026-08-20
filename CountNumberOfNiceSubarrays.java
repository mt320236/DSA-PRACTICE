/*
LeetCode 1248 - Count Number of Nice Subarrays

Approach:
- Convert each number into binary based on whether it is odd or even.
- Odd numbers contribute 1, while even numbers contribute 0.
- Use the sliding window technique to count subarrays with at most k odd numbers.
- The number of subarrays with exactly k odd numbers is:
  
  atMost(k) - atMost(k - 1)

- For every right pointer r, (r - l + 1) represents the number
  of valid subarrays ending at r.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return findValue(nums, k) - findValue(nums, k - 1);
    }

    public int findValue(int[] nums, int k) {

        if (k < 0) return 0;

        int l = 0;
        int r = 0;
        int sum = 0;
        int total = 0;

        while (r < nums.length) {

            sum += nums[r] % 2;

            while (sum > k) {
                sum -= nums[l] % 2;
                l++;
            }

            total += r - l + 1;
            r++;
        }

        return total;
    }
}
