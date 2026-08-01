/*
LeetCode 3 - Longest Substring Without Repeating Characters

Approach:
- Use Sliding Window with HashMap.
- Expand the window using the right pointer.
- If a duplicate character is found inside the current window,
  move the left pointer just after its previous occurrence.
- Keep updating the maximum window size.

Time Complexity: O(n)
Space Complexity: O(1)
*/

import java.util.HashMap;

class Solution {
    public int lengthOfLongestSubstring(String s) {

        HashMap<Character, Integer> map = new HashMap<>();

        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {

            char ch = s.charAt(right);

            if (map.containsKey(ch) && map.get(ch) >= left) {
                left = map.get(ch) + 1;
            }

            map.put(ch, right);

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
