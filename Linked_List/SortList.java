/*
Approach:
1. Find the middle of the linked list using slow and fast pointers.
2. Split the list into two halves.
3. Recursively sort both halves.
4. Merge the two sorted halves using the merge function.

Time Complexity: O(n log n)
Space Complexity: O(log n)
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
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode middle = findMiddle(head);
        ListNode left = head;
        ListNode right = middle.next;
        middle.next = null;

        left = sortList(left);
        right = sortList(right);

        return merge(left, right);
    }

    public ListNode findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public ListNode merge(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        ListNode temp1 = list1;
        ListNode temp2 = list2;
        ListNode head;

        if (temp1.val <= temp2.val) {
            head = temp1;
            temp1 = temp1.next;
        } else {
            head = temp2;
            temp2 = temp2.next;
        }

        ListNode temp3 = head;

        while (temp1 != null && temp2 != null) {
            if (temp1.val <= temp2.val) {
                temp3.next = temp1;
                temp1 = temp1.next;
            } else {
                temp3.next = temp2;
                temp2 = temp2.next;
            }
            temp3 = temp3.next;
        }

        if (temp1 != null) temp3.next = temp1;
        if (temp2 != null) temp3.next = temp2;

        return head;
    }
}
