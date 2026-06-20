/*
LeetCode 202 - Happy Number

Approach:
- Calculate the sum of squares of digits repeatedly.
- Store visited numbers in a HashSet.
- If the number becomes 1, return true.
- If the same number appears again, return false as it enters a cycle.

Time Complexity: O(log n)
Space Complexity: O(log n)
*/

class Solution {
    public boolean isHappy(int n) {
        Set<Integer> s=new HashSet<>();
        
        while(n!=1){
            int sum=0;
            if(s.contains(n)){
                return false;
            }
            
            
            s.add(n);
            while(n>0){
            int digit=n%10;
             n=n/10;
            sum+=digit*digit;

            
            
            
            
           
        
        }
        n=sum;
       
        }
        
        
        return true;
        
    }
}

