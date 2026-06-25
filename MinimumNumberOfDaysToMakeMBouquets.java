/*
Topic - Binary Search
LeetCode 1482 - Minimum Number of Days to Make m Bouquets

Approach:
- Use Binary Search on the answer (number of days).
- The search space ranges from the minimum bloom day to the maximum bloom day.
- For each candidate day, count how many bouquets can be formed using consecutive
  flowers that have bloomed on or before that day.
- If at least m bouquets can be formed, try to find a smaller valid day.
- Otherwise, search in the right half.
- Return the minimum day required to make m bouquets.

Time Complexity: O(n * log(maxBloomDay))
Space Complexity: O(1)
*/

class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        return search(bloomDay,m,k,minRange(bloomDay),maxRange(bloomDay));
        
    }
    public int maxRange(int [] bloomDay){
        int max=0;
        
        for(int e: bloomDay){
            max=Math.max(max,e);
            

        }
        return max;
    }
    public int minRange(int [] nums){
        int min=nums[0];
        for(int e: nums){
            min=Math.min(min,e);}
            return min;

    }

    public int search(int [] nums,int m,int k,int low,int high){
        if((long)m*k>nums.length) return -1;
        int minDay=high;
        while(low<=high){
            
            int mid=low+(high-low)/2;
            int totalBouquet=findPair(nums,m,k,mid);
            if(totalBouquet>=m){
                minDay=Math.min(minDay,mid);
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return minDay;


    }
    public int findPair(int [] nums,int m,int k,int mid){
        int totalBouquet=0;
        int count=0;
        for(int e: nums){
            if(e<=mid){
                count++;

            }
            else{
                totalBouquet+=count/k;
                count=0;
            }
            

        }
        totalBouquet+=count/k;
        return totalBouquet;

    }
}
