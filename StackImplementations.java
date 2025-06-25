class StackImplementations {

	public static void main(String[] args) {
	    
	   // StackLinkedListImplementation st = new StackLinkedListImplementation(); 
	   // st.push(1);
	   // st.push(2);
	   // st.push(3);
	   // st.push(4);

	    // Array Implementation of Stack
	    int[] arr = new int[5];
	    int index = 0; 
	    arr[index++] = 1; 
	    arr[index++] = 2; 
	    arr[index++] = 3; 
	    arr[index++] = 4; 
	    arr[index++] = 5;
	    
	    System.out.println("Top of the stack: " + arr[index - 1]);
	    index--; 
	    System.out.println("Top of the stack: " + arr[index - 1]);
	    index--;
	    System.out.println("Top of the stack: " + arr[index - 1]);

	    // ArrayList Implementation of Stack
	   	ArrayList<Integer> stack = new ArrayList<>(); 
	   	stack.add(1);
	   	stack.add(2);
		stack.add(3);
		stack.add(4);
		stack.add(5);
		
		System.out.println("Top of the stack is: " + stack.get(stack.size() - 1));
		stack.remove(stack.size() - 1);
		System.out.println("Top of the stack is: " + stack.get(stack.size() - 1));
		stack.remove(stack.size() - 1);
		System.out.println("Top of the stack is: " + stack.get(stack.size() - 1));
	    
	    // Stack Implementation using Deque
	    Deque<Integer> stack = new LinkedList<>();
		stack.offerFirst(1);
		stack.offerLast(2);
		stack.offerLast(3);
		stack.offerLast(4);
			
		System.out.println(stack);
		stack.pollLast(); 
		System.out.println(stack);
	    
	    /**
	     *  Operations on Deque
	     *  1. offerLast
	     *  2. offerFirst
	     *  3. pollLast
	     *  4. pollFirst
	     *  5. peekFirst
	     *  6. peekLast
	     **/
	}
}

class StackLinkedListImplementation {
    private class Node {
        int data; 
        Node next; 
        
        public Node(int data) {
            this.data = data; 
            this.next = null; 
        }
    }
    
    Node head; 
    
    public void push(int val) {
        Node newNode = new Node(val);
        
        if (head == null) {
            head = newNode; 
            return; 
        }
        
        newNode.next = head; 
        head = newNode; 
    }
    
    public void pop() {
        if (head == null) {
            System.out.println("Stack is empty. can't pop.");
            return;
        }
        
        Node temp = head; 
        head = head.next; 
        temp = null; 
    }
    
    public void top() {
        if (head == null) {
            System.out.println("Stack is empty. can't access top of the stack");
            return;
        }
        System.out.println("Top of the stack: " + head.data);
    }
    
    public void printStack() {
        Node temp = head; 
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}
    