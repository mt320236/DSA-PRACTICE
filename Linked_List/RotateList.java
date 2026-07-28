/*
Approach:
1. Find the length of the linked list.
2. Reduce k using modulo (k % length).
3. If k is a multiple of the length, return the original list.
4. Connect the last node to the head to form a circular list.
5. Move to the (length - k)th node to find the new tail.
6. Make the next node the new head and break the circular link.

Time Complexity: O(n)
Space Complexity: O(1)
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) return head;

        int ln = 1;
        ListNode temp = head;

        while (temp.next != null) {
            temp = temp.next;
            ln++;
        }

        if (k % ln == 0) return head;

        k = k % ln;
        temp.next = head;

        int cnt = 1;
        temp = head;

        while (cnt != ln - k) {
            temp = temp.next;
            cnt++;
        }

        head = temp.next;
        temp.next = null;

        return head;
    }
}
