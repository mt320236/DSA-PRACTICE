/*
LeetCode 18 - 4Sum

Approach:
- Sort the array.
- Fix the first two elements using nested loops.
- Use two pointers to find the remaining two elements.
- Skip duplicate values to avoid duplicate quadruplets.

Time Complexity: O(n³)
Space Complexity: O(1) (excluding the output list)
*/


class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans= new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            if(i>0 && nums[i]==nums[i-1]){
                continue;
            }
            for(int j= i+1; j<nums.length;j++){
                if(j>i+1 && nums[j]==nums[j-1]){
                    continue;
                }
                int k=j+1;
                int l=nums.length-1;
                while(k<l){
                    
                    long sum=(long)nums[i]+nums[j]+nums[k]+nums[l];
                    if(sum==target){
                        List<Integer> ls=new ArrayList<>();
                        ls.add(nums[i]);
                        ls.add(nums[j]);
                        ls.add(nums[k]);
                        ls.add(nums[l]);
                        ans.add(ls);

                        k++;
                        l--;
                        while(k<l && nums[k]==nums[k-1]){
                            
                            k++;

                        }
                        while(k<l && nums[l]==nums[l+1]){
                            l--;
                            
                        }
                    }
                    else if(sum>target){
                        l--;
                         }
                    else{
                        k++;
                        }

                    }
                    
                }
                
            }
            return ans;


        }
        
    }
