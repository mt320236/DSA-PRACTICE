/*
K-th Element of Two Sorted Arrays

Approach:
- Perform Binary Search on the smaller array.
- Partition both arrays such that the left partition contains exactly k elements.
- Check if the partition is valid using:
    max(left1, left2) <= min(right1, right2)
- If the partition is valid, the K-th element is the maximum element
  in the left partition.
- Otherwise, adjust the partition using Binary Search.

Time Complexity: O(log(min(n1, n2)))
Space Complexity: O(1)
*/

class Solution {
    public int kthElement(int[] a, int[] b, int k) {
      
     return findMedian(a,b,k);
        

        
    }
    public int findMedian(int [] nums1,int [] nums2,int k){
        int n1=nums1.length;
        int n2=nums2.length;
        if(n1>n2) return findMedian(nums2,nums1,k);
        int low=Math.max(0,k-n2);
        int high=Math.min(k,n1);
        
        while(low<=high){
            int mid1=low+(high-low)/2;
            int mid2=k-mid1;
            int l1=Integer.MIN_VALUE;
            int l2=Integer.MIN_VALUE;
            int r1=Integer.MAX_VALUE;
            int r2=Integer.MAX_VALUE;
            if(mid1!=n1) r1=nums1[mid1];
            if(mid2!=n2) r2=nums2[mid2];
            if(mid1-1>=0) l1=nums1[mid1-1];
            if(mid2-1>=0) l2=nums2[mid2-1];
            if(l1<=r2 && l2<=r1){
                
                return Math.max(l1,l2);
            }
            else if(l2>r1) low=mid1+1;
            else{
                high=mid1-1;
            }



        }
        return 0;
    }
    
    
}
