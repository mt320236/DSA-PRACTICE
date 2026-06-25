/*
Topic- Binary Search
Problem: Find Nth Root of a Number

Approach:
- Use Binary Search over the range [1, M].
- For each mid, calculate mid^N using a helper function.
- The helper function returns:
  - 1 if mid^N == M
  - 2 if mid^N > M
  - 0 if mid^N < M
- Based on the returned value, move to the left or right half.
- If no integer Nth root exists, return -1.

Time Complexity: O(N * log M)
Space Complexity: O(1)
*/

class Solution {
    public int NthRoot(int N, int M) {
        return search(N,M,1,M);
        
    }
    public int search(int N,int M,int low,int high){
        while(low<=high){
            int mid=low+(high-low)/2;
            int result=calculation(mid,N,M);
            if(result==1) return mid;
            else if(result==2) high=mid-1;
            else{
                low=mid+1;
            }
        }
        return -1;

    }
    public int calculation(int mid,int N,int M){
        long result=1;
        for(int i=0;i<N;i++){
             result=result*mid;
             if(result>M) return 2;

             
        }
        if (result==M) return 1;
        return 0;
    }
}
