import java.util.*;

/*
 * Minimum Platforms
 *
 * Approach:
 * Sort arrival and departure times separately.
 * Use two pointers to track the next arrival and departure.
 * If a train arrives before or at the departure time,
 * increase the platform count.
 * Otherwise, free a platform.
 *
 * Time Complexity: O(n log n)
 * Space Complexity: O(1) extra space
 */

class Solution {
    public int findPlatform(int[] Arrival, int[] Departure) {
        Arrays.sort(Arrival);
        Arrays.sort(Departure);

        int i = 0;
        int j = 0;
        int count = 0;
        int maxPlatforms = 0;

        while (i < Arrival.length) {
            if (Arrival[i] <= Departure[j]) {
                count++;
                maxPlatforms = Math.max(maxPlatforms, count);
                i++;
            } else {
                count--;
                j++;
            }
        }

        return maxPlatforms;
    }
}
