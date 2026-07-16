/*
 * LeetCode 206: Reverse Linked List
 *
 * Approach:
 * - Use three pointers to reverse the linked list in-place.
 * - Store the next node before modifying the current node's next pointer.
 * - Reverse the current link and move all pointers one step forward.
 * - Continue until all nodes are processed.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
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
    public ListNode reverseList(ListNode head) {
        if(head==null || head.next==null) return head;
        ListNode back=null;
        ListNode front=head.next;
        while(head!=null){
            front=head.next;
            head.next=back;
            back=head;
            head=front;
            

            
        }
        return back;
        
    }
}
