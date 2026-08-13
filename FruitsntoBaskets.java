/*
LeetCode 904 - Fruit Into Baskets

Approach:

- Use a sliding window with two pointers: left and right.
- Use a HashMap to store the frequency of each fruit type in the current window.
- Expand the window by moving the right pointer and adding the current fruit.
- If the window contains more than 2 distinct fruit types, shrink it from
  the left until only 2 types remain.
- Update the maximum window length whenever the window is valid.

Time Complexity: O(n)
Space Complexity: O(1) since the map stores at most 3 fruit types.
*/

class Solution {
    public int totalFruit(int[] fruits) {
        int l = 0;
        int r = 0;
        int length = 0;

        Map<Integer, Integer> mpp = new HashMap<>();

        while (r < fruits.length) {

            mpp.put(fruits[r], mpp.getOrDefault(fruits[r], 0) + 1);

            while (mpp.size() > 2) {
                mpp.put(fruits[l], mpp.get(fruits[l]) - 1);

                if (mpp.get(fruits[l]) == 0) {
                    mpp.remove(fruits[l]);
                }

                l++;
            }

            length = Math.max(length, r - l + 1);
            r++;
        }

        return length;
    }
}
