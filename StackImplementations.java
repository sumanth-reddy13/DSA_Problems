class StackImplementations {
	public static void main(String[] args) {
	    
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

/**
 * Stack Implementation using Linked List
 * 1. push operation is O(1).
 * 2. pop and top operations are O(1).
 * 3. value is inserted at the head of the linked list.
 * 4. pop operation removes the head of the linked list.
 */
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
    

/**
 * Stack Implementation using two Queues
 * 1. push operation is costly, takes O(N) time.
 * 2. pop and top operations are O(1).
 */
public class StackImplementationUsingQueue {
    Queue<Integer> q1; 
    Queue<Integer> q2; 
    
    public StackImplementationUsingQueue() {
        q1 = new LinkedList<>(); 
        q2 = new LinkedList<>(); 
    }

    /*
        push operation is costly. Takes O(N)
    */
    public void push(int val) {
        q1.offer(val);
        
        while (!q2.isEmpty()) {
            q1.offer(q2.poll());
        }
        
        Queue<Integer> temp = q1; 
        q1 = q2; 
        q2 = temp;
    }
    
    public void pop() {
        if (q2.isEmpty()) return; 
        int val = q2.poll(); 
        System.out.println("popped value: " + val);
    }
    
    public void top() {
        if (q2.isEmpty()) return;   // isEmpty() is Collection interface method. 
        int val = q2.peek(); 
        System.out.println("Top value: " + val);
    }
}


/**
 * Stack Implementation using two Queues
 * 1. push operation is O(1).
 * 2. pop and top operations are costly, takes O(N) time.
 */
public class StackImplementationUsingQueue1 {
    Queue<Integer> q1; 
    Queue<Integer> q2; 
    
    public StackImplementationUsingQueue1() {
        q1 = new LinkedList<>(); 
        q2 = new LinkedList<>(); 
    }

    public void push(int val) {
        q1.offer(val);
    }
    
    public void pop() {
        if (q1.isEmpty()) return; 
        
        int size = q1.size(); 

        while (q1.size() != 1) {
            q2.offer(q1.poll());
        }
        
        int val = q1.poll(); 
        System.out.println("popped value: " + val);
        
        Queue<Integer> temp = q1; 
        q1 = q2; 
        q2 = temp; 
    }
    
    public void top() {
        if (q1.isEmpty()) return;   // isEmpty() is Collection interface method. 
        int size = q1.size(); 
        
        while (q1.size() != 1) {
            q2.offer(q1.poll());
        }
        
        int val = q1.peek(); 
        System.out.println("Top value: " + val);
        q2.offer(q1.poll());
        
        Queue<Integer> temp = q1; 
        q1 = q2; 
        q2 = temp;
    }
}

/**
 * Stack Implementation using One Queue
 * 1. push operation is O(1).
 * 2. pop and top operations are costly, takes O(N) time.
 */

public class StackImplementationOneQueue {
    Queue<Integer> q1; 
    
    public StackImplementationOneQueue() {
        q1 = new LinkedList<>(); 
    }

    public void push(int val) {
        q1.offer(val);
    }
    
    public void pop() {
        if (q1.isEmpty()) return; 
        
        int size = q1.size(); 
        for (int i = 0; i < size - 1; i++) {
            q1.offer(q1.poll());
        }
        
        int val = q1.poll(); 
        System.out.println("popped value: " + val);
    }
    
    public void top() {
        if (q1.isEmpty()) return; 
        
        int size = q1.size(); 
        for (int i = 0; i < size - 1; i++) {
            q1.offer(q1.poll());
        }
        
        int val = q1.peek();
        q1.offer(q1.poll());
        System.out.println("Top value: " + val);
    }
}