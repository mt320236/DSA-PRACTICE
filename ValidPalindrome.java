/*
Approach:
1. Use two pointers, one at the beginning and one at the end.
2. Skip all non-alphanumeric characters.
3. Compare characters after converting them to lowercase.
4. If any pair doesn't match, return false.
5. If all pairs match, return true.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }

            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }

            if (Character.toLowerCase(s.charAt(left)) !=
                Character.toLowerCase(s.charAt(right))) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}
