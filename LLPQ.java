

// LLPQ class implements priority queue
class LLPQ {
	
	
	// Node class 
	class Node {
		
	    char data; 
	    int priority; 
	    Node next; 
	    
	    // Constructor for the node class
	    public Node(char data, int priority) {
	        this.data = data;
	        this.priority = priority;
	        this.next = null;
	    }
	}
	
    private Node head; // Head of the queue
    private int size; 

    
    // Constructor for the LLPQ class
    public LLPQ() {
        this.head = null;
        this.size = 0;
    }
    

    // method for inserts a node into the priority queue based on its priority
    public void insert(char addedData, int priority) {
    	
        Node newnode = new Node(addedData, priority);
        
        if (head == null || priority < head.priority) {
        	
            newnode.next = head;
            head = newnode;
            
        }
        
        else {
        	
            Node current = head;
            
            while (current.next != null && current.next.priority <= priority) {
                current = current.next;
            }
            
            newnode.next = current.next;
            
            current.next = newnode;
        }
        size++;
    }

    // method for removes and returns the data of the node with the highest priority
    public char removeMin() {
    	
        if (head == null) {
        	
            System.out.println("Empty queue");
        }
        
        char minData = head.data;
        
        head = head.next;
        size--;
        
        return minData;
    }

    // method for returns the data of the node with the highest priority
    public char min() {
        if (head == null) {
        	
            System.out.println("Empty queue");
        }
        
        return head.data;
    }

    
    // gives the size of the priority queue
    public int size() {
        return size;
    }

    
    // Prints the elements of the queue
    public void printQueue() {
    	
        Node current = head;
        while (current != null) {
            System.out.print("(" + current.data  + current.priority + ")  > ");
            current = current.next;
        }
        
        System.out.println("NULL");
    }

    // Main method for the test cases and creating priority queue
    public static void main(String[] args) {
    	
    	// creating queue object
        LLPQ priorityQueue = new LLPQ();

        //inserting and creating given queue
        priorityQueue.insert('E', 5);
       
        priorityQueue.insert('G', 2);
        
        priorityQueue.insert('C', 4);
        
        priorityQueue.insert('A', 1);
        
        priorityQueue.insert('U', 3);

        // test cases
        System.out.print("Priority Queue : ");
        priorityQueue.printQueue();

        
        System.out.println("Size of the queue: " + priorityQueue.size());
        System.out.println("Min: " + priorityQueue.min());
       

        System.out.println("Removed Min " + priorityQueue.removeMin());
        
        System.out.print(" After removing min ");
        priorityQueue.printQueue();
        
    }
}



































