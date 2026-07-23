/*
LeetCode 19 - Remove Nth Node From End of List

Approach:
1. Initialize two pointers: fast and slow.
2. Move the fast pointer n steps ahead.
3. If fast becomes null, remove the head node.
4. Move both pointers until fast reaches the last node.
5. Delete the target node by updating the next pointer.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        ListNode slow = head;

        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        if (fast == null) {
            return head.next;
        }

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;
        return head;
    }
}
