/*
Approach:
1. Traverse the array while storing each element in a HashSet.
2. If an element already exists in the set, return true.
3. If the traversal completes without duplicates, return false.

Time Complexity: O(n)
Space Complexity: O(n)
*/

class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            }
            set.add(num);
        }

        return false;
    }
}
