// Greedy approach:
// Keep track of available $5 and $10 bills.
// For a $10 bill, give one $5 as change.
// For a $20 bill, prefer $10 + $5 to preserve $5 bills.
// If neither option is possible, return false.
// Time: O(n)
// Space: O(1)

class Solution {
    public boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;

        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) {
                five++;
            }
            else if (bills[i] == 10) {
                if (five > 0) {
                    five--;
                    ten++;
                }
                else {
                    return false;
                }
            }
            else {
                if (ten > 0 && five > 0) {
                    ten--;
                    five--;
                }
                else if (five >= 3) {
                    five -= 3;
                }
                else {
                    return false;
                }
            }
        }

        return true;
    }
}
