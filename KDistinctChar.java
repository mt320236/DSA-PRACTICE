/*
Approach:
- Use a sliding window with two pointers: left and right.
- Store the frequency of each character in a HashMap.
- Expand the window by moving right.
- If the window contains more than k distinct characters,
  shrink it from the left until it becomes valid again.
- Track the maximum valid window length.

Time Complexity: O(n)
Space Complexity: O(k)
*/

class Solution {
    public int kDistinctChar(String s, int k) {
        int l = 0;
        int r = 0;
        int length = 0;

        Map<Character, Integer> mpp = new HashMap<>();

        while (r < s.length()) {

            // Add current character
            mpp.put(
                s.charAt(r),
                mpp.getOrDefault(s.charAt(r), 0) + 1
            );

            // Shrink window if distinct characters exceed k
            while (mpp.size() > k) {
                mpp.put(
                    s.charAt(l),
                    mpp.get(s.charAt(l)) - 1
                );

                if (mpp.get(s.charAt(l)) == 0) {
                    mpp.remove(s.charAt(l));
                }

                l++;
            }

            length = Math.max(length, r - l + 1);
            r++;
        }

        return length;
    }
}
