/*
LeetCode 2769 - Find the Maximum Achievable Number

Approach:
- Each operation can increase the maximum achievable value by 2.
- After performing at most t operations, the maximum achievable value becomes num + 2*t.

Time Complexity: O(1)
Space Complexity: O(1)
*/

class Solution {
    public int theMaximumAchievableX(int num, int t) {
        return num +2*t;
        
        
    }
}
