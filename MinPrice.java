/*
Approach:
- Sort prices and discounts.
- Apply the largest discount to the most expensive price.
- This maximizes the total discount.
- If discounts run out, add the remaining prices normally.

Time Complexity: O(n log n + m log m)
Space Complexity: O(1) auxiliary space
*/

class Solution {
    public double minPrice(int[] prices, int[] discounts) {
        Arrays.sort(prices);
        Arrays.sort(discounts);

        double sum = 0;

        int l = prices.length - 1;
        int r = discounts.length - 1;

        while (l >= 0) {
            if (r == -1) {
                sum += prices[l];
                l--;
            } else {
                sum += prices[l] * (double) (100 - discounts[r]) / 100;
                l--;
                r--;
            }
        }

        return sum;
    }
}
