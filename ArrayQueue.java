
public class ArrayQueue {
	
    private String[] queue;
    
    private int front;
    
    private int rear;
    
    private int capacity;
    
    private int count;

    
    
    // constructor for initialize the queue
    
    public ArrayQueue(int size) {
        queue = new String[size];
        capacity = size;
        front = 0;
        rear = -1;
        count = 0;
    }

    
    // method to add an element to the queue
    public void enqueue(String s) {
    	
    	if (count == capacity) {
       
            return;
        }
    	
        rear++;
        if (rear == capacity) {
            rear = 0; 
        }
        
        
        queue[rear] = s;
        count++;
    }

    
    // method for remove  element from the queue
    
    public String dequeue() {
    	
    	if (isEmpty()) {
            
            return null;
        }
    	
    	
        String s = queue[front];
        front++;
        if (front == capacity) {
            front = 0; 
        }
        count--;
        
        return s;
    }

    
    // method for return the size of the queue
    
    public int size() {
        return count;
    }

    
    // Method to check if the queue is empty
    
    public boolean isEmpty() {
        return count == 0;
    }

    // method for print the elements in the queue
    
    public void printQueue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }
        for (int i = 0; i < count; i++) {
            System.out.print(queue[(front + i) % capacity] + " ");
        }
        System.out.println();
    }

    
    
    // Main method to test the queue operations
    public static void main(String[] args) {
    	
    	// crating queue 
    	
    	ArrayQueue  queue = new ArrayQueue (10);
        queue.enqueue("10");
        queue.enqueue("20");
        queue.enqueue("30");
        queue.enqueue("40");
        
        queue.printQueue(); 
        
        queue.dequeue();
        queue.printQueue(); 
        
        System.out.println("Size " + queue.size()); 
        System.out.println("booelan " + queue.isEmpty()); 
    }
}
