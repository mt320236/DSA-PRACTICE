/*Problem: Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

Approach:
- Store all elements in a HashSet.
- Start counting only from numbers whose predecessor is not present.
- Extend the sequence using HashSet lookups.

Time Complexity: O(n)
Space Complexity: O(n)
  */



class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        int largest=1;
        
        HashSet<Integer> st=new HashSet<>();
        for(int i=0;i<nums.length;i++){
            st.add(nums[i]);
        }
        for(int it:st){
            if(!st.contains(it-1)){
                int x=it;
                
                int count=1;
                while(st.contains(x+1)){
                    x++;
                    count++;
                    largest=Math.max(largest,count);
                }
               
            }
            
        }
        return largest;
        
    }
}
