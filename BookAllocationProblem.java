/*
Topic - Binary Search
Allocate Minimum Number of Pages


Approach:
- Use Binary Search on the maximum pages assigned to a student.
- The minimum possible value is the maximum number of pages in a single book,
  and the maximum possible value is the sum of all pages.
- For each candidate value, greedily allocate consecutive books to students
  and count the minimum number of students required.
- If the required students are within the given limit, try to minimize the
  maximum pages by searching the left half.
- Otherwise, search in the right half.
- Return the minimum possible maximum pages assigned to any student.

Time Complexity: O(n * log(sumOfPages))
Space Complexity: O(1)
*/

class Solution {
    public int findPages(int[] nums, int m) {
        if(nums.length<m) return -1;
        return search(nums,m,findLow(nums),findHigh(nums));
   
    }
    public int findLow(int [] nums){
        int maxEl=nums[0];
        for(int e:nums){
            maxEl=Math.max(maxEl,e);

        }
        return maxEl;
    }
    public int findHigh(int  [] nums){
        int sum=0;
        for(int e: nums){
            sum+=e;
        }
        return sum;
    }
    public int search(int [] nums,int m,int low,int high){
        while(low<=high){
            int mid=low+(high-low)/2;
            int st=findStudent(nums,mid);
            if(st<=m){
                high=mid-1;
            }
            else{
                low=mid+1;

            }
        }
        return low;

    }
    public int findStudent(int [] nums,int mid){
        int student=1;
        int pages=0;
        for(int i=0;i<nums.length;i++){
            if(pages+nums[i]<=mid){
                pages+=nums[i];
            }
            else{
                student++;
                pages=nums[i];
            }

        }
        return student;

        
    }
}
