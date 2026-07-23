/*
LeetCode 234 - Palindrome Linked List

Approach:
1. Find the middle of the linked list using slow and fast pointers.
2. Reverse the second half of the list.
3. Compare the first half and the reversed second half.
4. Restore the original linked list by reversing the second half again.
5. Return true if all corresponding nodes match; otherwise return false.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;

        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode newHead = reverseList(slow.next);
        ListNode first = head;
        ListNode second = newHead;

        while (second != null) {
            if (first.val != second.val) {
                reverseList(newHead);
                return false;
            }
            first = first.next;
            second = second.next;
        }

        reverseList(newHead);
        return true;
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode back = null;
        ListNode front = head.next;

        while (head != null) {
            front = head.next;
            head.next = back;
            back = head;
            head = front;
        }

        return back;
    }
}
