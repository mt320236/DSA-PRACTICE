/*
 * Delete Head of a Doubly Linked List
 *
 * Approach:
 * - Handle edge cases for an empty list or a single-node list.
 * - Move the head pointer to the next node.
 * - Set the new head's previous pointer to null.
 * - Return the updated head.
 *
 * Time Complexity: O(1)
 * Space Complexity: O(1)
 */

class Solution {
    public ListNode deleteHead(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        head = head.next;
        head.prev = null;

        return head;
    }
}
