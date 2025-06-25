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