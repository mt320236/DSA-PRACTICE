/*
Approach:
1. Traverse the sorted array.
2. Mark the starting element of a range.
3. Continue while consecutive numbers are found.
4. If the range has one element, add it directly.
5. Otherwise, add it in the format "start->end".

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<>();

        int i = 0;

        while (i < nums.length) {
            int start = nums[i];

            while (i + 1 < nums.length && nums[i] + 1 == nums[i + 1]) {
                i++;
            }

            if (start == nums[i]) {
                ans.add(String.valueOf(start));
            } else {
                ans.add(start + "->" + nums[i]);
            }

            i++;
        }

        return ans;
    }
}
