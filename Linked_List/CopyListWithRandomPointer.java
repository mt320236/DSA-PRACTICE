/*
LeetCode 138 - Copy List with Random Pointer

Approach:
1. Insert copied nodes between original nodes.
2. Assign random pointers to copied nodes.
3. Separate the copied list from the original list.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null;

        Node temp = head;

        // Step 1: Create copy nodes and insert them after original nodes
        while (temp != null) {
            Node copy = new Node(temp.val);
            copy.next = temp.next;
            temp.next = copy;
            temp = copy.next;
        }

        // Step 2: Assign random pointers
        temp = head;
        while (temp != null) {
            if (temp.random != null) {
                temp.next.random = temp.random.next;
            }
            temp = temp.next.next;
        }

        // Step 3: Separate the copied list
        Node dummy = new Node(-1);
        Node copyTail = dummy;
        temp = head;

        while (temp != null) {
            Node copy = temp.next;

            temp.next = copy.next;
            copyTail.next = copy;
            copyTail = copy;

            temp = temp.next;
        }

        return dummy.next;
    }
}
