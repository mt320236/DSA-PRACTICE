/*
LeetCode 141 - Linked List Cycle

Approach:
1. Initialize two pointers: slow and fast.
2. Move slow by one step and fast by two steps.
3. If the pointers meet, a cycle exists in the linked list.
4. If fast reaches the end of the list, no cycle exists.

Time Complexity: O(n)
Space Complexity: O(1)
*/

public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;

        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) return true;
        }

        return false;
    }
}
