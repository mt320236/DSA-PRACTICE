/*
Topic- String
LeetCode 344 - Reverse String

Approach:
- Use two pointers, one at the beginning and one at the end.
- Swap the characters and move both pointers towards the center.
- Continue until the middle of the array is reached.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {
    public void reverseString(char[] s) {
        int j = s.length - 1;

        for(int i = 0; i < s.length / 2; i++) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            j--;
        }
    }
}
