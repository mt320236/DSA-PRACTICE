/*
LeetCode 1903 - Largest Odd Number in String

Approach:
- Traverse the string from right to left.
- Check each digit to determine whether it is odd.
- The first odd digit encountered from the end represents the largest
  possible odd-numbered prefix.
- Return the substring from index 0 to that odd digit.
- If no odd digit exists, return an empty string.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {
    public String largestOddNumber(String num) {

        for (int i = num.length() - 1; i >= 0; i--) {

            char ch = num.charAt(i);

            if ((ch - '0') % 2 != 0) {
                return num.substring(0, i + 1);
            }
        }

        return "";
    }
}
