/*
LeetCode 1358 - Number of Substrings Containing All Three Characters

Approach:
- Use a sliding window with two pointers: l and r.
- freq[] stores the frequency of 'a', 'b', and 'c' in the current window.
- Expand the window using r.
- Once the window contains all three characters, every substring
  extending from r to the end is also valid, so add (n - r).
- Shrink the window from the left using l.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {
    public int numberOfSubstrings(String s) {

        int l = 0;
        int totalNo = 0;
        int[] freqSet = new int[3];

        for (int r = 0; r < s.length(); r++) {

            freqSet[s.charAt(r) - 'a']++;

            while (freqSet[0] > 0 &&
                   freqSet[1] > 0 &&
                   freqSet[2] > 0) {

                totalNo += s.length() - r;

                freqSet[s.charAt(l) - 'a']--;
                l++;
            }
        }

        return totalNo;
    }
}
