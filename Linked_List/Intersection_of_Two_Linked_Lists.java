/*
LeetCode 160 - Intersection of Two Linked Lists

Approach:
1. Initialize two pointers for both linked lists.
2. Traverse each list.
3. When a pointer reaches the end, redirect it to the head of the other list.
4. The pointers will either meet at the intersection node or both become null.
5. Return the intersection node.

Time Complexity: O(m + n)
Space Complexity: O(1)
*/

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA;
        ListNode b = headB;

        while (a != b) {
            a = (a == null) ? headB : a.next;
            b = (b == null) ? headA : b.next;
        }

        return a;
    }
}
