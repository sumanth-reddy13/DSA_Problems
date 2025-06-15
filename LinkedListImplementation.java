class Node {
	int data; 
	Node next; 
	
	public Node(int data) {
		this.data = data; 
		this.next = null; 
	}
}

public class LL {
    Node head; 
    
    public LL() {
        head = null; 
    }
    
	// insert a new node at the end of the Linked List.
	// Time Complexity: O(n) where n is the number of nodes in the Linked List.
    public void insert(int val) {
        if (head == null) {
            head = new Node(val);
            return;
        }
        Node temp = head; 
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = new Node(val);
    }
    
	// Traverse the Linked List. 
    public void traverseLL(Node head) {
        Node temp = head; 
        while (temp.next != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next; 
        }
        System.out.println(temp.data);
    }
    
    public void reverseLL() {
        Node temp = reverseLL(head);
        traverseLL(temp);
    }
    
	// reversing a LinkedList using traversal method. 
    public Node reverseLL(Node head) {                
        Node prev = null;
        Node curr = head; 
        Node next = head.next; 
        
        while (curr != null) {
            curr.next = prev; 
            prev = curr; 
            curr = next; 
            if (next != null) {
                next = next.next; 
            }
        }
        return prev; 
    }
    
	// Reverse a Linked List using recursion.
    public void reverseRecur() {
        Node temp = reverseRecur(head, null);
        traverseLL(temp);
    }
    
	// Approach 1: Reverse a Linked List using recursion.
    private Node reverseRecur(Node head, Node prev) {
        if (head.next == null) {
            head.next = prev; 
            return head; 
        }
        
        Node temp = reverseRecur(head.next, head);
        head.next = prev; 
        return temp; 
    }
    
	// Approach 2: Reverse a Linked List using recursion.
    public Node reverseRecur(Node head) {
        if (head.next == null) return head; 
        Node tHead = reverseRecur(head.next);
        head.next.next = head;
        head.next = null; 
        
        return tHead; 
    }
    
    // length of a Linked List
    public void lengthLL() {
        Node temp = head;
        int count = 0;
        
        while (temp != null) {
            count++;
            temp = temp.next; 
        }
        
        System.out.println("Length of the Linked List: " + count);
        System.out.println("Recursion: Length of the linked List : " + lengthLLRecur(head));
    }
    
	// Recursive method to find the length of a Linked List.
    public int lengthLLRecur(Node head) {
        if (head == null) return 0; 
        return 1 + lengthLLRecur(head.next);
    }
}











