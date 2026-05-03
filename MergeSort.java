//Problem: Sort Array
//Approach: Merge Sort
//Time: O(nlogn) | Space: O(n)

class Solution {
    public int[] sortArray(int[] nums) {
        mergeSort(nums,0,nums.length-1);       
        
        return nums;

        

        
    }
    public void mergeSort(int [] nums,int si,int ei){
         if(si>=ei){
            return ;
        }
        int mid=(si+ei)/2;
        mergeSort(nums,si,mid);
        mergeSort(nums,mid+1,ei);
        merge(nums,si,ei,mid);

    }
    public void merge(int [] nums,int si,int ei,int mid){
        int i=si;
        int j=mid+1;
        int k=0;
        int [] temp=new int[(ei-si)+1];
        while(i<=mid&&j<=ei){
            if(nums[i]<nums[j]){
                temp[k]=nums[i];
                i++;
            }
            else{
                temp[k]=nums[j];
                j++;
            }
            k++;
        } 
             
            while(i<=mid){
                temp[k]=nums[i];
                i++;
                k++;

            }
            while(j<=ei){
                temp[k]=nums[j];
                j++;
                k++;
            }
            for(int l=0;l<temp.length;l++){
                nums[si+l]=temp[l];
            }
    }
}
        

    
