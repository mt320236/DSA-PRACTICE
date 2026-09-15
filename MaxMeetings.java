import java.util.Arrays;

/*
 * Max Meetings
 *
 * Approach:
 * Sort meetings by their ending time.
 * Always select the meeting that finishes earliest
 * and does not overlap with the previously selected meeting.
 *
 * Time Complexity: O(n log n)
 * Space Complexity: O(n)
 */

class Solution {
    public int maxMeetings(int[] start, int[] end) {
        Integer[] arr = new Integer[start.length];

        for (int i = 0; i < start.length; i++) {
            arr[i] = i;
        }

        Arrays.sort(arr, (a, b) -> end[a] - end[b]);

        int lastEnd = -1;
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            int meeting = arr[i];

            if (start[meeting] > lastEnd) {
                count++;
                lastEnd = end[meeting];
            }
        }

        return count;
    }
}
