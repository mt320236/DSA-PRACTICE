/*
Find Length of Loop in a Linked List

Approach:
1. Use Floyd's Cycle Detection algorithm to check if a loop exists.
2. If slow and fast pointers meet, a cycle is present.
3. Keep one pointer fixed and move the other pointer until it reaches the same node again.
4. Count the number of nodes traversed during this process.
5. Return the count; if no cycle exists, return 0.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {
    public int findLengthOfLoop(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return lengthOfLoop(slow, fast);
            }
        }

        return 0;
    }

    public int lengthOfLoop(ListNode slow, ListNode fast) {
        int cnt = 1;
        fast = fast.next;

        while (fast != slow) {
            cnt++;
            fast = fast.next;
        }

        return cnt;
    }
}

