/*
430. Flatten a Multilevel Doubly Linked List
You are given a doubly linked list which in addition to the next and previous pointers, 
it could have a child pointer, which may or may not point to a separate doubly linked list. 
These child lists may have one or more children of their own, and so on, to produce a multilevel data structure.
Flatten the list so that all the nodes appear in a single-level, doubly linked list. 
You are given the head of the first level of the list.

*/

// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
}


class Solution {
	public Node flatten(Node head) {
		if (head == null) {
			return null;
		}
		Node res = head;
        //Stack to save ends of each row
		Stack<Node> save = new Stack<Node>();
		while (head.next != null || head.child != null) {
			if (head.child != null) {
				save.push(head.next);
				head.next = head.child;
                // reset prev pointer
				head.next.prev = head;
                // delete child 
				head.child = null;
			}

			head = head.next;
            // are we at the end of one row and have to move up to upper row
			if (head.next == null && head.child == null && !save.isEmpty()) {
				head.next = save.pop();
				if (head.next != null) {
					head.next.prev = head;
				}
			}

		}

		return res;
	}
}
