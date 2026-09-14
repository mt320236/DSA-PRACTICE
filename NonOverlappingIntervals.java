

/*

 *
 * Approach:
 * Sort intervals by their end time.
 * Keep the interval that finishes earliest.
 * If the next interval overlaps, remove it.
 *
 * Time Complexity: O(n log n)
 * Space Complexity: O(1) extra space
 */

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);

        int count = 0;
        int prevEnd = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < prevEnd) {
                count++;
            } else {
                prevEnd = intervals[i][1];
            }
        }

        return count;
    }
}
