/*
LeetCode 56 - Merge Intervals

Approach:
- Sort intervals by start time.
- Traverse intervals and merge overlapping intervals.
- If current interval overlaps with the last merged interval,
  update the end value.
- Otherwise, add it as a new interval.

Time Complexity: O(n log n)
Space Complexity: O(n)
*/


class Solution {
    public int[][] merge(int[][] intervals) {
       Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> merged = new ArrayList<>();

        for (int[] interval : intervals) {

            if (merged.isEmpty() ||
                merged.get(merged.size() - 1)[1] < interval[0]) {

                merged.add(interval);

            } else {

                merged.get(merged.size() - 1)[1] =
                        Math.max(
                                merged.get(merged.size() - 1)[1],
                                interval[1]
                        );
            }
        }

        return merged.toArray(new int[merged.size()][]);

        
    }
}
