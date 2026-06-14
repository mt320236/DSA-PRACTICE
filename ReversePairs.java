/*
Problem: Reverse Pairs (LeetCode 493)

Approach:
- Use Merge Sort.
- Count reverse pairs before merging.
- For every element in the left sorted half,
  find how many elements in the right sorted half satisfy:
      nums[i] > 2 * nums[j]
- Merge the two sorted halves.

Time Complexity: O(n log n)
Space Complexity: O(n)
*/


class Solution {
    public int reversePairs(int[] nums) {
        return mergeSort(nums,0,nums.length-1);


        
    }
    public int countPairs(int [] nums ,int l , int r, int mid){
        int count=0;
        int j=mid+1;
        for(int i= l; i<=mid; i++){
            while(j<=r && nums[i]>2L*nums[j]){
                j++;
                
            }
            count+=j-(mid+1);

        }
        return count;


    }
   public int mergeSort(int [] nums,int l,int r){
    int count=0;
    if(l>=r) return count;
    int mid=(l+r)/2;

   count+= mergeSort(nums,l,mid);
    count +=mergeSort(nums,mid+1,r);
    count+= countPairs(nums, l,r,mid);
    merge(nums,l,r,mid);
    return count;

   }
   public void merge(int [] nums, int l, int r, int mid){
    
    List <Integer> ls = new ArrayList<>();
    int i=l;
    int j=mid+1;
    while(i<=mid && j<= r){

        if(nums[i]>nums[j]){
            ls.add(nums[j++]);
            
            

        }
        else{
            ls.add(nums[i++]);
        }
    }
    while(i<=mid){
            ls.add(nums[i++]);
    }
    while(j<=r){
            ls.add(nums[j++]);
    }
    for(int k=l;k<=r;k++){
        nums[k]=ls.get(k-l);
    }
        



     
   }
  
    
}
