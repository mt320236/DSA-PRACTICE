// Greedy approach:
// Sort burst times and execute the shortest job first.
// This minimizes the total waiting time.
// Time: O(n log n)
// Space: O(1)

class Solution {
    public long solve(int[] bt) {
        Arrays.sort(bt);

        long waitingTime = 0;
        long t = 0;

        for (int i = 0; i < bt.length; i++) {
            waitingTime += t;
            t += bt[i];
        }

        return waitingTime / bt.length;
    }
}
