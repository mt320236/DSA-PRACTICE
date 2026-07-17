/*
 * Add Two Numbers
 *
 * Approach:
 * - Traverse both linked lists simultaneously.
 * - Add corresponding digits along with the carry.
 * - Create a new node for each digit of the sum.
 * - Append the remaining carry, if any, after traversal.
 *
 * Time Complexity: O(max(n, m))
 * Space Complexity: O(max(n, m))
 */



/*
Definition of singly linked list:
class ListNode{
    public int data;
    public ListNode next;
    ListNode() { data = 0; next = null; }
    ListNode(int x) { data = x; next = null; }
    ListNode(int x, ListNode next) { data = x; this.next = next; }
}
*/

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode current;
        ListNode dummy=new ListNode(-1);
        current=dummy;
        int carry=0;
        int sum=0;
        while(l1!=null || l2!=null){
            sum=0;
            sum+=carry;
            carry=0;
            if(l1!=null) sum+=l1.data;
            if(l2!=null) sum+=l2.data;
            carry=sum/10;
            ListNode newNode=new ListNode(sum%10);
            current.next=newNode;
            current=current.next;
            if(l1!=null) l1=l1.next;
            if(l2!=null) l2=l2.next;
            
        }
        if(carry!=0){
            ListNode temp=new ListNode(carry);
            current.next=temp;

        } 
        return dummy.next;
        
    }
}
