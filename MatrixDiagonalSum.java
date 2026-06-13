/*
Problem: Matrix Diagonal Sum (LeetCode 1572)

Approach:
- Traverse the primary diagonal and add elements.
- Traverse the secondary diagonal simultaneously.
- Avoid double-counting the center element when the matrix size is odd.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {
    public int diagonalSum(int[][] mat) {
        int sum = 0;

        for (int i = 0; i < mat.length; i++) {

            sum += mat[i][i];

            if (i != mat.length - i - 1) {
                sum += mat[i][mat.length - i - 1];
            }
        }

        return sum;
    }
}
