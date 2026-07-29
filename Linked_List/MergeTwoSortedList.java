/*
Approach:
1. Handle edge cases where either list is empty.
2. Choose the smaller first node as the head.
3. Compare nodes from both lists and attach the smaller one to the merged list.
4. Continue until one list is exhausted.
5. Attach the remaining nodes of the other list.

Time Complexity: O(n + m)
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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        ListNode temp1 = list1;
        ListNode temp2 = list2;
        ListNode head = null;

        if (temp1.val >= temp2.val) {
            head = temp2;
            temp2 = temp2.next;
        } else {
            head = temp1;
            temp1 = temp1.next;
        }

        ListNode temp3 = head;

        while (temp1 != null && temp2 != null) {
            if (temp1.val >= temp2.val) {
                temp3.next = temp2;
                temp3 = temp3.next;
                temp2 = temp2.next;
            } else {
                temp3.next = temp1;
                temp3 = temp3.next;
                temp1 = temp1.next;
            }
        }

        if (temp1 != null) temp3.next = temp1;
        if (temp2 != null) temp3.next = temp2;

        return head;
    }
}
