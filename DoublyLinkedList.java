

public class DoublyLinkedList<T> {
	


	// 1.a - generic Node<T> Class
	
	private class Node<T> {
		
		T data;
        Node<T> next;
        	    Node<T> prev;

        // constructor to initialize node with data
        public Node(T data) {
        	
            this.data = data;
           
            this.next = null;
            
        }
		
	
	}
	
	 private Node<T> header;
	    private Node<T> trailer;

	    //  1.b - constructor
	    
	    public DoublyLinkedList() {
	    	
	        this.header = new Node<>(null);  
	        this.trailer = new Node<>(null); 
	        this.header.next = this.trailer;
	        this.trailer.prev = this.header;
	        
	    }
	
	    
	    
	    
	    // 1.c - Append function
	    
	    public void append(T data) {
	        Node<T> newNode = new Node<>(data);
	        Node<T> last = trailer.prev; // Last node before the trailer
	        last.next = newNode;
	        newNode.prev = last;
	        newNode.next = trailer;
	        trailer.prev = newNode;
	    }
	    
	    
	    //1.d - function to delete a node with a specific value
	    
	    public void delete(T data) {
	    	
	        Node<T> current = header.next;
	        
	        while (current != trailer) {
	        	
	            if (current.data== data) {
	            	
	                Node<T> prevNode = current.prev;
	                
	                Node<T> nextNode = current.next;
	                
	                prevNode.next = nextNode;
	                
	                nextNode.prev = prevNode;
	                return;
	            }
	            current = current.next;
	        }
	    }
	
	
	
	// 1.e display function to see a elements on terminal
	    public void display() {
	        Node<T> current = header.next;
	        System.out.print("header < >");
	        
	        while (current != trailer) {
	            System.out.print(current.data +  "< >");
	            current = current.next;
	        }
	        
	        System.out.println(" trailer");
	    }
	
	

	
	
	// 1.g -- main function for test cases
	    
	public static void main(String[] args) {
		
		                  // String type DLL
        DoublyLinkedList<String> StrDLL = new DoublyLinkedList<>();
        StrDLL.append("hello");
        
        StrDLL.append("from");
        StrDLL.append("the earth");
        StrDLL.display();
        
        StrDLL.delete("the earth");
        StrDLL.display();
        
        System.out.println();

                            // 1.g  integer type DLL
        
        DoublyLinkedList<Integer> IntDLL = new DoublyLinkedList<>();
        
        
        IntDLL.append(4);
        IntDLL.append(8);
        IntDLL.append(15);
        IntDLL.append(16);
        
        IntDLL.display();
        
        
        IntDLL.delete(16);
        IntDLL.display();
		

	}
	
	
	/* 1.h -  Time Complexity Answers:
	 * 
	 *     1- Append Funciton: Takes O(1) time becuase of append function directly accesses the last node
	 *     it does constant operation at the end of the list which is adding node
	 * 
	 *     2- Delete Function :In the worst case it takes O(n) times because of it traverse entire list to find and delete the node
	 * 
	 *     3- Display Function: Takes O(n) time because of it start from beginning to the end of list for print all nodes in DLL
	  
	  
	 */

	
	
	
}
