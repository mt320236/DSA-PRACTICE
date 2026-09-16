import java.util.*;

 /*
  * LeetCode 56 - Merge Intervals
  *
  * Approach:
  * Sort intervals by their starting time.
  * Merge overlapping intervals by comparing the current
  * interval with the last merged interval.
  *
  * Time Complexity: O(n log n)
  * Space Complexity: O(n)
  */

class Solution {
    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<int[]> result = new ArrayList<>();

        int start = intervals[0][0];
        int end = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {

            if (intervals[i][0] <= end) {
                end = Math.max(end, intervals[i][1]);
            } else {
                result.add(new int[]{start, end});

                start = intervals[i][0];
                end = intervals[i][1];
            }
        }

        result.add(new int[]{start, end});

        return result.toArray(new int[result.size()][]);
    }
}
