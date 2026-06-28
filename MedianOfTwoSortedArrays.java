/*
Topic - Binary Search
LeetCode 4 - Median of Two Sorted Arrays

Approach:
- Always perform Binary Search on the smaller array.
- Partition both arrays such that the total number of elements on the left
  equals the required left partition size.
- Check if the partitions are valid using:
    max(left1, left2) <= min(right1, right2)
- If the partition is valid:
    - For odd total elements, the median is the maximum element on the left.
    - For even total elements, the median is the average of the maximum left
      and minimum right elements.
- Otherwise, adjust the binary search boundaries based on the partition.

Time Complexity: O(log(min(n1, n2)))
Space Complexity: O(1)
  */
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        return findMedian(nums1,nums2);
        

        
    }
    public double findMedian(int [] nums1,int [] nums2){
        int n1=nums1.length;
        int n2=nums2.length;
        if(n1>n2) return findMedian(nums2,nums1);
        int low=0;
        int high=nums1.length;
        int leftReq=(n1+n2+1)/2;
        while(low<=high){
            int mid1=low+(high-low)/2;
            int mid2=leftReq-mid1;
            int l1=Integer.MIN_VALUE;
            int l2=Integer.MIN_VALUE;
            int r1=Integer.MAX_VALUE;
            int r2=Integer.MAX_VALUE;
            if(mid1!=n1) r1=nums1[mid1];
            if(mid2!=n2) r2=nums2[mid2];
            if(mid1-1>=0) l1=nums1[mid1-1];
            if(mid2-1>=0) l2=nums2[mid2-1];
            if(l1<=r2 && l2<=r1){
                if((n1+n2)%2!=0) return Math.max(l1,l2);
                return (( double)Math.max(l1,l2)+(double)Math.min(r1,r2))/2.0;
            }
            else if(l2>r1) low=mid1+1;
            else{
                high=mid1-1;
            }



        }
        return 0;
    }
    
    
}
