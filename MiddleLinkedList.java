/*Given a non-empty, singly linked list with head node head, return a middle node of linked list.

If there are two middle nodes, return the second middle node.
*/

class MiddleLinkedList {
    public ListNode middleNode(ListNode head) {
        int z = 1; 
        ListNode speicher = head;
        while(speicher.next !=null){
            z++;
            speicher = speicher.next;
        }
        
        z/=2;
        while(z>0){
            head = head.next; 
            z--;
        }
        return head; 
    }
}
