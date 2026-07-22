/*
LeetCode 876 - Middle of the Linked List

Approach:
1. Initialize two pointers: slow and fast.
2. Move slow by one node and fast by two nodes.
3. When fast reaches the end, slow points to the middle node.
4. If there are two middle nodes, return the second one.

Time Complexity: O(n)
Space Complexity: O(1)
*/


class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }
}
