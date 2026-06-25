/*
Topic - Binary Search
LeetCode 875 - Koko Eating Bananas

Approach:
- Use Binary Search on the possible eating speed (k).
- The minimum possible speed is 1 and the maximum is the largest pile.
- For each candidate speed, calculate the total hours required to eat all the bananas.
- If the required hours are within the given limit, try to find a smaller valid speed.
- Otherwise, increase the eating speed.
- Return the minimum eating speed that allows Koko to finish within h hours.

Time Complexity: O(n * log(maxPile))
Space Complexity: O(1)
*/

class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        return search(piles,h,1,maxEl(piles));

        
    }
    public int maxEl(int [] piles){
        int max=piles[0];
        for(int e:piles){
            max=Math.max(max,e);
        }
        return max;
    }
    public int search(int [] piles,int h,int low,int high){
        int minHour=high;
        while(low<=high){
            
            int mid=low+(high-low)/2;
            long result=hourCalculation(mid,piles);
            if(result<=h){
                minHour=Math.min(minHour,mid);
                high=mid-1;


            }
            else{
                low=mid+1;
            }


        }
        return minHour;

    }
    public long hourCalculation(int mid,int [] piles){
        long result=0;
        for(int e:piles){
            if(e<mid) result+= 1;
            else{
                result+=e/mid;
                if(e%mid!=0){
                    result++;
                }
            }

        }
        return result;
    }
}
