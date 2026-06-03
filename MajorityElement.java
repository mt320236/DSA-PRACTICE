/*
LeetCode 169 - Majority Element

Approach: Moore's Voting Algorithm
- Maintain a candidate and a count.
- Matching elements increase the count.
- Different elements decrease the count.
- The majority element survives all cancellations.

Time Complexity: O(n)
Space Complexity: O(1)
*/


class Solution {
    public int majorityElement(int[] nums) {
        int count = 1;
        int candidate = nums[0];

        for(int i = 1; i < nums.length; i++) {

            if(count == 0) {
                candidate = nums[i];
            }

            if(nums[i] != candidate) {
                count--;
            } else {
                count++;
            }
        }

        return candidate;
    }
}
