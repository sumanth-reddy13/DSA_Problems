public class QueueImplementations {
	public static void main(String[] args) {
		
	}
}

** Basic Operations on Queue **
1. offer/enqueue
2. poll/dequeue
3. peek
4. isEmpty
5. isFull

// Basic Implementation of Queue using Array
class QueueBasicImplementation {
    int[] queue; 
    int size; 
    int front; 
    int capacity; 
    
    public QueueBasicImplementation(int capacity) {
        this.queue = new int[capacity];
        this.capacity = capacity; 
        this.front = 0; 
        this.size = 0;
    }
    
    public void enqueue(int val) {         
        if (isFull()) return; 
        int rear = (front + size); 
        queue[rear] = val; 
        size++;
        
        System.out.println("added " + val + " to the queue");
    }
    
    public int dequeue() {        
        if (isEmpty()) return -1; 
        int val = queue[front]; 
        
        for (int i = front; i < front + size - 1; i++) {
            queue[i] = queue[i + 1];
        }
        
        size--;
        return val; 
    }
    
    public int peek() {
        if (isEmpty()) return -1; 
        return queue[front];
    }
    
    public int tail() {
        if (isEmpty()) return -1; 
        return queue[(front + size - 1)];
    }
    
    public boolean isEmpty() {
        System.out.println("Queue is Empty");
        return size == 0;
    }
    
    public boolean isFull() {
        System.out.println("Queue is Full");
        return size == capacity;
    }
}


// This is a circular queue implementation.
class CircularQueue {
    int[] queue; 
    int capacity; 
    int front; 
    int size; 
    
    public Queue(int capacity) {
        this.queue = new int[capacity];
        this.capacity = capacity; 
        this.front = 0; 
        this.size = 0;
    }
    
    public void enqueue(int val) {         
        if (isFull()) return; 
        int rear = (front + size) % capacity; 
        queue[rear] = val; 
        size++;
        
        System.out.println("added " + val + " to the queue");
    }
    
    public int dequeue() {        
        if (isEmpty()) return -1; 
        int val = queue[front]; 
        front = (front + 1) % capacity;
        size--; 
        return val; 
    }
    
    public int peek() {
        if (isEmpty()) return -1; 
        return queue[front];
    }
    
    public int tail() {
        if (isEmpty()) return -1; 
        return queue[(front + size - 1) % capacity];
    }
    
    public boolean isEmpty() {
        return size == 0; 
    }
    
    public boolean isFull() {
        System.out.println("size: " + size + " capacity " + capacity);
        return size == capacity;
    }
}

// Queue Implementation using Linked List
class QueueLLImple {
    
    private static class Node {
        int data; 
        Node next; 
        
        private Node(int data) {
            this.data = data; 
            this.next = null; 
        }
    }
    
    Node front; 
    Node rear; 
    int size; 
    
    public QueueLLImple() {
        this.front = this.rear = null; 
        this.size = 0; 
    }

    public void enqueue(int val) {
        Node newNode = new Node(val);
        if (isEmpty()) {
            front = rear = newNode; 
            return; 
        }
        rear.next = newNode;
        rear = newNode; 
		size++;
        printQueue(); 
    }
    
    public void dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return; 
        }
        front = front.next; 
        if (front == null) rear = null; 
		size--;
        printQueue(); 
    }
    
    public void peek() {
        if (isEmpty()) {
            System.out.println("Queue is Empty");
            return;
        }
        System.out.println("peek value: " + front.data);
    }
    
    public boolean isEmpty() {
        return front == null;
    }
    
    public void printQueue() {
        Node temp = front; 
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next; 
        }
        System.out.println();
    }
}

/**
 	1. Queue Implementation Using Two Stacks
	2. offer operation is costly, takes O(N) time.
	3. poll and peek operations are O(1).
 */
class QueueImplementationUsingStack {
    Stack<Integer> s1; 
    Stack<Integer> s2; 
    
    public QueueImplementationUsingStack() {
        s1 = new Stack<>(); 
        s2 = new Stack<>();
    }
    
    public void offer(int val) {
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }
        s1.push(val);
        
        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }
    }
    
    public void poll() {
        if (s1.isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }
        int val = s1.pop();
        System.out.println("polled value: " + val);
    }
    
    public void peek() {
        if (s1.isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }
        int val = s1.peek();
        System.out.println("Peeked value: " + val);
    }
}


/**
	1. Queue Implementation Using Two Stacks.
	2. offer operation takes O(1) time.
	3. poll and peek operations take amortized O(1) time. 
 */
class QueueImplementationUsingStack1 {
    Stack<Integer> s1; 
    Stack<Integer> s2; 
    
    public QueueImplementationUsingStack1() {
        s1 = new Stack<>(); 
        s2 = new Stack<>();
    }
    
    public void offer(int val) {
        s1.push(val);
    }
    
    public void poll() {
        if (s1.isEmpty() && s2.isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }
        
        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
        
        int val = s2.pop();
        System.out.println("polled value: " + val);
    }
    
    public void peek() {
        if (s1.isEmpty() && s2.isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }
        
        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
        
        int val = s2.peek();
        System.out.println("Peeked value: " + val);
    }
}


/**
	1. Queue Implementation using Recursion
	2. offer operation is O(1).
	3. poll operation is O(N) due to recursion. space is O(N) as well.
	4. peek operation is O(N) due to recursion. space is O(N) as well.
 */
public class QueueImplementationUsingRecursion {
    Stack<Integer> s1; 
    
    public QueueImplementationUsingRecursion() {
        s1 = new Stack(); 
    }
    
    public void offer(int val) {
        s1.push(val);
    }
    
    public void poll() {
        if (s1.isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }
        
        int val = recur();
        System.out.println("dequeued value: " + val);
    }
    
    public int recur() {
        int x = s1.peek();
        s1.pop(); 
        
        if (s1.isEmpty()) {
            return x; 
        }
        
        int temp = recur();
        
        s1.push(x);
        
        return temp; 
    }
}