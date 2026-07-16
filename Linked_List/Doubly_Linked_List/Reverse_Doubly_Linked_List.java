/*
 * Reverse a Doubly Linked List
 *
 * Approach:
 * - Traverse the list and swap the previous and next pointers of each node.
 * - Move to the next node using the updated previous pointer.
 * - Return the new head of the reversed list.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {
    public ListNode reverseDLL(ListNode head) {
        ListNode current = head;
        ListNode last = null;

        while (current != null) {
            last = current.prev;
            current.prev = current.next;
            current.next = last;
            current = current.prev;
        }

        if (last == null)
            return head;

        return last.prev;
    }
}
