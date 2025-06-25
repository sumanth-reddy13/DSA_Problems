class DequeImplementations {
	public static void main(String[] args) {
		
	}
}


// Circular Deque Implementation using Array
class CircularDequeImplementation {
    int[] queue; 
    int capacity; 
    int front; 
    int size; 
    
    public CircularDequeImplementation(int capacity) {
        this.queue = new int[capacity];
        this.capacity = capacity; 
        this.front = 0; 
        this.size = 0;
    }
    
    public void offerLast(int val) {         
        if (isFull()) return; 
        int rear = (front + size) % capacity; 
        queue[rear] = val; 
        size++;
        // printQueue();
    }
    
    public void offerFirst(int val) {
        if (isFull()) return; 
        front = (front - 1 + capacity) % capacity; 
        queue[front] = val; 
        size++; 
        // printQueue();
    }
    
    public int pollFirst() {        
        if (isEmpty()) {
            System.out.println("Deque is empty");
            return -1; 
        }
        
        int val = queue[front]; 
        front = (front + 1) % capacity;
        size--; 
        printQueue();
        return val; 
    }
    
    public int pollLast() {
        if (isEmpty()) {
            System.out.println("Deque is empty");
            return -1;
        }
        
        int val = queue[(front + size - 1) % capacity];
        size--; 
        printQueue();
        return val; 
    }
    
    public int peekFirst() {
        if (isEmpty()) return -1; 
        return queue[front];
    }
    
    public int peekLast() {
        if (isEmpty()) return -1; 
        return queue[(front + size - 1) % capacity];
    }
    
    public boolean isEmpty() {
        return size == 0; 
    }
    
    public boolean isFull() {
        return size == capacity;
    }
    
    public void printQueue() {
        if (size == 0) {
            System.out.println("Deque is empty");
            return;
        }
        
        for (int i = front; i < front + size; i++) {
            System.out.print(queue[i % capacity] + " ");
        }
        System.out.println();
    }
}

// Deque implementation using Doubly LinkedList
