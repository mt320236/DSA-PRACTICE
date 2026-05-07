/**
 * LeetCode #342 - Power of Four
 * Time Complexity: O(log4 n) 
 * Space Complexity: O(1) 
 */
class Solution {
    public boolean isPowerOfFour(int n) {
        if(n==1 || n==4){
            return true;
        }
        while(n>0){
            if(n%4!=0){
                return false;
            }
            n=n/4;
            if(n==4){
                return true;
            }
        }
        return false;
    }
}
