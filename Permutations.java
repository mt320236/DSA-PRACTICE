/*
LeetCode 46 - Permutations

Approach:
- Use backtracking with swapping.
- Fix one element at the current index and recursively generate
  permutations for the remaining elements.
- After recursion, swap back to restore the original array
  (backtracking).
- When the index reaches the end of the array, store the current
  permutation in the answer list.

*/

class Solution {

    private void recurPermute(int index, int[] nums, List<List<Integer>> ans) {

        // Base Case
        if (index == nums.length) {
            List<Integer> ds = new ArrayList<>();

            for (int num : nums) {
                ds.add(num);
            }

            ans.add(new ArrayList<>(ds));
            return;
        }

        // Try every element at the current index
        for (int i = index; i < nums.length; i++) {

            // Swap
            swap(i, index, nums);

            // Recur for next index
            recurPermute(index + 1, nums, ans);

            // Backtrack
            swap(i, index, nums);
        }
    }

    private void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();

        recurPermute(0, nums, ans);

        return ans;
    }
}
