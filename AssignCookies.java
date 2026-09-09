// Greedy approach:
// Sort both arrays and use two pointers.
// Match each child with the smallest cookie that can satisfy their greed.
// If the cookie is too small, move to the next cookie.
// Time: O(n log n + m log m)
// Space: O(1)

class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int i = 0;
        int j = 0;

        while (i < g.length && j < s.length) {
            if (s[j] >= g[i]) {
                i++;
                j++;
            } else {
                j++;
            }
        }

        return i;
    }
}
