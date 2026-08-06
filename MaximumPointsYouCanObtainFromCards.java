/*
Approach:
1. Take the sum of the first k cards from the left.
2. Initialize it as the maximum score.
3. Gradually remove one card from the left and add one card from the right.
4. Update the maximum score after each shift.
5. Return the maximum score obtained.

Time Complexity: O(k)
Space Complexity: O(1)
*/

class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int leftSum = 0;
        int rightSum = 0;

        for (int i = 0; i < k; i++) {
            leftSum += cardPoints[i];
        }

        int maxSum = leftSum;
        int rIndex = cardPoints.length - 1;

        for (int i = k - 1; i >= 0; i--) {
            leftSum -= cardPoints[i];
            rightSum += cardPoints[rIndex];
            rIndex--;

            maxSum = Math.max(maxSum, leftSum + rightSum);
        }

        return maxSum;
    }
}
