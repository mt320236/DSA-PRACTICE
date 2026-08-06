/*
LeetCode 485 - Max Consecutive Ones

Approach:
1. Traverse the array once.
2. Count consecutive 1's.
3. Reset the count whenever a 0 is encountered.
4. Keep track of the maximum count throughout the traversal.
5. Return the maximum consecutive 1's.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxOne = 0;
        int cnt = 0;

        for (int num : nums) {
            if (num == 1) {
                cnt++;
                maxOne = Math.max(maxOne, cnt);
            } else {
                cnt = 0;
            }
        }

        return maxOne;
    }
}
