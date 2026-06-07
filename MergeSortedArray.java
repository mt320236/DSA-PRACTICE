/*
LeetCode 88 - Merge Sorted Array

Approach:
- Use three pointers from the end of the arrays.
- Compare the largest remaining elements of nums1 and nums2.
- Place the larger element at the end of nums1.
- Continue until all elements are merged.

Time Complexity: O(m + n)
Space Complexity: O(1)
*/


class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int k= nums1.length-1;
        int j= nums2.length-1;
        int i=m-1;
        while(i>-1 && j>-1){
            if(nums1[i]>nums2[j]){
                nums1[k]=nums1[i];
                i--;

            }
            else{
                nums1[k]=nums2[j];
                j--;
            }
            k--;



        }
    
        
        while(j>-1){
            nums1[k]=nums2[j];
            j--;
            k--;
        }
       
        
    

        
        
    }
}
