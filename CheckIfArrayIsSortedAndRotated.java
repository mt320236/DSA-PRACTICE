/*
LeetCode 1752 - Check if Array Is Sorted and Rotated

Approach:
- Count the number of positions where the current element is greater than the next element.
- A sorted and rotated array can have at most one such break in order.
- Use modulo (%) to compare the last element with the first element, treating the array as circular.

Time Complexity: O(n)
Space Complexity: O(1)
*/


class Solution {
    public boolean check(int[] nums) {
        int count = 0;
        int n = nums.length;

        for(int i = 0; i < n; i++) {
            if(nums[i] > nums[(i + 1) % n]) {
                count++;
                if(count > 1) return false;
            }
        }

        return true;
    }
}
