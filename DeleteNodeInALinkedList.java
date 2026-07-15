/*
 * LeetCode 237: Delete Node in a Linked List
 *
 * Approach:
 * - The head of the linked list is not provided, so the previous node cannot be accessed.
 * - Copy the value of the next node into the current node.
 * - Update the current node's next pointer to skip the next node.
 * - This effectively deletes the given node in O(1) time.
 *
 * Time Complexity: O(1)
 * Space Complexity: O(1)
 */

class Solution {
    public void deleteNode(ListNode node) {
        node.val=node.next.val;
        node.next=node.next.next;
}
