/**
 * LeetCode #326 - Power of Three
 * Time Complexity: O(log3 n) 
 * Space Complexity: O(1) 
 */
class Solution {
    public boolean isPowerOfThree(int n) {
        if(n==1 || n==3){
            return true;
        }
        while(n>0){
            if(n%3!=0){
                return false;
            }
            n=n/3;
            if(n==3){
                return true;
            }
        }
        return false;
    }
}
