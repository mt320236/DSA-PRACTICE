/*
LeetCode 229 - Majority Element II

Approach:
- Use Boyer-Moore Voting Algorithm to find two potential candidates.
- Verify their frequencies in a second pass.

Time Complexity: O(n)
Space Complexity: O(1)
*/



class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int el1=Integer.MIN_VALUE;
        int el2=Integer.MIN_VALUE;
        int c1=0;
        int c2=0;
        int n=nums.length;
        for(int i=0;i<n;i++){
            if(c1==0 && nums[i]!=el2){
                c1++;
                el1=nums[i];
            }
             else if(c2==0 && nums[i]!=el1){
                c2++;
                el2=nums[i];
            }
            else if(nums[i]==el1){
                c1++;
            }
             else if(nums[i]==el2){
                c2++;
            }
            else{
                c1--;
                c2--;
            }
        }
        c1=0; c2=0;
        List<Integer> ls=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(el1==nums[i]){
                c1++;

            }
            if(el2==nums[i]){
                c2++;

            }
            
        }
        if(c1>(n/3)){
                ls.add(el1);
            }
            if(c2>(n/3)){
                ls.add(el2);
            }
        return ls;
        
    }
}
