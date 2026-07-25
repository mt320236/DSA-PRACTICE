/*
LeetCode 142 - Linked List Cycle II

Approach:
1. Use slow and fast pointers to detect if a cycle exists.
2. If the pointers meet, reset the slow pointer to the head.
3. Move both pointers one step at a time.
4. The node where they meet again is the starting node of the cycle.
5. Return the starting node; otherwise, return null.

Time Complexity: O(n)
Space Complexity: O(1)
*/

public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                slow = head;

                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }

                return slow;
            }
        }

        return null;
    }
}
