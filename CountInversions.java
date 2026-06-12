/*
Problem: Count Inversions in an Array

Approach:
- Use Merge Sort.
- Count inversions while merging.
- If nums[i] > nums[j], then all elements from i to mid
  will form inversions with nums[j].

Time Complexity: O(n log n)
Space Complexity: O(n)
*/


class Solution {
    
        
    public long numberOfInversions(int[] nums) {
        
        return merging(nums,0,nums.length-1);
        


        
    }
    public long merging(int [] nums, int l,int r){
        int cnt=0;
        if(l>=r) return cnt;
        
        
        int mid=(l+r)/2;
        cnt+=merging(nums,l,mid);
        cnt+=merging(nums,mid+1,r);
         cnt+=merge(nums,l,r,mid);
         return cnt;
    }
    public long merge(int [] nums,int l,int r,int mid){
        List <Integer> ls= new ArrayList<>();
        int cnt=0;
        int i=l;
        int j=mid+1;
        while(i<=mid && j<= r){
            
    
         if(nums[i]>nums[j]){
            ls.add(nums[j++]);
            cnt+=mid-i+1;


         }
         else if(nums[i]<=nums[j]){
            ls.add(nums[i++]);
         }
        }
        while(i<=mid){
            ls.add(nums[i++]);
        }
        while(j<=r){
            ls.add(nums[j++]);
        }
        for(int k=l; k<=r;k++){
            nums[k]=ls.get(k-l);
        }
        return cnt;


    }
    
    
}

    
