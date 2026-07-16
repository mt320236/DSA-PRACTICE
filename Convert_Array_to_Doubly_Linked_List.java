/*
 * Convert Array to Doubly Linked List
 *
 * Approach:
 * - Create the head node using the first array element.
 * - Maintain a pointer to the previous node.
 * - For each remaining element:
 *   - Create a new node.
 *   - Link the previous node to the new node.
 *   - Set the new node's previous pointer.
 * - Return the head of the doubly linked list.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

class Node1{
    int data;
    Node1 next;
    Node1 previous;
    Node1(int data,Node1 next, Node1 previous){
        this.data=data;
        this.next=next;
        this.previous=previous;

    }
    Node1(int data){
        this.data=data;
        next=null;
        previous=null;
    }

}
public class DLL {
    public static Node1 convert2DLL(int [] arr){
        Node1 head=new Node1(arr[0]);
        Node1 prev=head;
        for(int i=1;i< arr.length;i++){
            Node1 temp=new Node1(arr[i],null,prev);
            prev.next=temp;
            prev=temp;
        }
        return head;


    }
    public static void printDll(Node1 head){
        while(head!=null){
            System.out.println(head.data);
            head=head.next;
        }
    }
    public static void main(String[] args) {
        int [] arr={5,3,1,8,2};
        Node1 head=convert2DLL(arr);
        printDll(head);
    }
}
