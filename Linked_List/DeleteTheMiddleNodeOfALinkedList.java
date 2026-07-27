/*
LeetCode 2095 - Delete the Middle Node of a Linked List

Approach:
1. Handle the edge case where the list has only one node.
2. Use slow and fast pointers to find the middle node.
3. Keep track of the node before the middle using a prev pointer.
4. Delete the middle node by updating prev.next.
5. Return the modified linked list.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {
    public ListNode deleteMiddle(ListNode head) {
        if (head == null || head.next == null) return null;

        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = slow;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = prev.next.next;
        return head;
    }
}
