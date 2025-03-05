

//DLLDequeue Class

public class DLLDequeue<E> {
	
	
	// creating Node Class
	class Node<E> {
		
	    E data;
	    Node<E> next;
	    Node<E> prev;
	    
	    
// constructor for node class
	    Node(E data) {
	        this.data = data;
	        this.next = null;
	        this.prev = null;
	    }
	}

	
	
	
	// creating nodes head and tail
	 private Node<E> head;
	 private Node<E> tail;
	 private int size;
	 

	 // Constructor
	 
	 public DLLDequeue() {
	     head = null;
	     tail = null;
	     size = 0;
	 }

	 // adding element at the front
	 
	 public void addFirst(E element) {
	     Node<E> newNode = new Node<>(element);
	     
	     if (isEmpty()) {
	    	 
	         head = tail = newNode;
	     } else {
	    	 
	    	 
	         newNode.next = head;
	         head.prev = newNode;
	         head = newNode;
	     }
	     
	     size++;
	     
	 }
	 

	 // adding element at the back
	 
	 public void addLast(E element) {
	     Node<E> newNode = new Node<>(element);
	     
	     if (isEmpty()) {
	         head = tail = newNode;
	         
	     } else {
	         tail.next = newNode;
	         newNode.prev = tail;
	         tail = newNode;
	     }
	     
	     size++;
	 }
	 
	 
	 

	 // method for remove and return element from the front
	 public E removeFirst() {
		 
	     if (isEmpty()) {
	    	 
	    	 System.out.println("Queue is empty");
	    	 
	     }
	     E data = head.data;
	     head = head.next;
	     
	     if (head == null) {
	         tail = null;
	         
	     } else {
	         head.prev = null;
	     }
	     size--;
	     return data;
	 }

	 
	 // method for removing and return element from the back
	 
	 public E removeLast() {
	     if (isEmpty()) {
	    	 
	    	 System.out.println("Queue is empty");
	     }
	     
	     E data = tail.data;
	     tail = tail.prev;
	     
	     if (tail == null) {
	         head = null;
	         
	     } else {
	         tail.next = null;
	     }
	     
	     size--;
	     
	     return data;
	 }

	 // method for return element at the front
	 public E First() {
	     if (isEmpty()) {
	    	 
	    	 System.out.println("Queue is empty");
	     }
	     return head.data;
	 }
	 

	 // method for return element at the back
	 
	 public E Last() {
	     if (isEmpty()) {
	    	 
	    	 System.out.println("Queue is empty");
	     }
	     
	     return tail.data;
	 }

	 
	 
	 // Return the size of the dequeue
	 public int size() {
		 
	     return size;
	 }

	 
	 
	 // Check if the dequeue is empty
	 public boolean isEmpty() {
		 
	     return size == 0;
	 }

	 // Print the elements in the dequeue
	 public void printDequeue() {
	     Node<E> current = head;
	     
	     while (current != null) {
	         System.out.print(current.data + (current.next != null ? " " : ""));
	         current = current.next;
	     }
	     
	     System.out.println();
	 }
	
	 
	 
// main function for test cases
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// creating dequeue structure
		DLLDequeue<Integer> dequeue = new DLLDequeue<>();

		
		// adding nodes on the queue
        dequeue.addFirst(10);
        dequeue.addFirst(20);
        dequeue.addFirst(30);
        dequeue.addLast(40);

        dequeue.printDequeue(); 

        System.out.println("Removed First: " + dequeue.removeFirst()); 
        
        dequeue.printDequeue(); 

        
        System.out.println("Removed Last: " + dequeue.removeLast()); 

        dequeue.printDequeue(); 

        System.out.println("First: " + dequeue.First());
        
        System.out.println("Last: " + dequeue.Last()); 
        System.out.println("Size: " + dequeue.size()); 
        System.out.println("Is Empty: " + dequeue.isEmpty()); 
        
        

	}

}
