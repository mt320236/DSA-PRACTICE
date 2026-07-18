/*
LeetCode 328 - Odd Even Linked List

Approach:
- Maintain separate odd and even pointers.
- Rearrange links in-place.
- Connect the even list after the odd list.

Time: O(n)
Space: O(1)
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
    public ListNode oddEvenList(ListNode head) {
        if(head==null || head.next==null) return head;
        
        ListNode odd=head;
        ListNode even=head.next;
        ListNode evenStart=head.next;
        while(even !=null && even.next !=null){
            odd.next=odd.next.next;
            odd=odd.next;
            even.next=even.next.next;
            even=even.next;
        }
        odd.next=evenStart;
        return head;
    }
    
}
