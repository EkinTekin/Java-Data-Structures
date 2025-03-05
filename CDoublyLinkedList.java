
public class CDoublyLinkedList<T> {

	
	
    // Node class for generic CdoublyLinkedlist
	
    private class Node<T> {
        T data;
        Node<T> next;
        Node<T> prev;

        public Node(T data) {
        	
            this.data = data;
            this.next = this; 
            this.prev = this;  
        }
    }
    
    
  

    private Node<T> header;

    // Constructor 
    
    
    public CDoublyLinkedList() {
        header = null;
    }

    
    
    
    // Append function to add data at the end
    
    public void append(T data) {
    	// creating obejct
        Node<T> newNode = new Node<>(data);

        
        // if list empty create a node
        if (header == null) {
            header = newNode;
            
        } 
        else {
            Node<T> tail = header.prev;
            tail.next = newNode;
            newNode.prev = tail;
            newNode.next = header;
            header.prev = newNode;
        }
    }
    
    

    // Delete method to remove a node by value
    public void delete(T data) {
    	
        if (header == null) return;

        
        Node<T> current = header;
        
        // boolean for prevent entering infinity loop
        boolean firstnode = true;
        
        while (current != header || firstnode) {
        	
        	firstnode = false; 

            if (current.data.equals(data)) {
            	
            	// if Only one node in the list 
            	
                if (current == header && current.next == header) {
                	
                    header = null; // deleting
                    
                } 
                
                else {
                	// reconnecting nodes
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                    if (current == header) {
                        header = current.next;
                    }
                }
                return;
            }
            current = current.next;
        }
    }

    
    

    // Display method to print list
    
    
    public void display() {
    	
        if (header == null) {
            System.out.println("header");
            return;
        }
        
        
        Node<T> current = header;
        
        boolean isFirstNode = true;
        
        System.out.print("header < > ");
        while (current != header || isFirstNode) {
        	
        	// to make ensure we only pass the header once
        	
            isFirstNode = false; 
            System.out.print(current.data + " < > ");
            current = current.next;
        }
        
        System.out.println("header");
    }
    

    
    // Main method with test cases of functions
    
    public static void main(String[] args) {
    	
        // String CDLL example
    	
        CDoublyLinkedList<String> StrCDLL = new CDoublyLinkedList<>();
        StrCDLL.append("hello");
        StrCDLL.append("from");
        StrCDLL.append("the earth");
        StrCDLL.display();
        StrCDLL.delete("from");
        StrCDLL.display();

        
        
        // Integer CDLL example
        
        
        CDoublyLinkedList<Integer> IntCDLL = new CDoublyLinkedList<>();
        IntCDLL.append(4);
        IntCDLL.append(8);
        IntCDLL.append(15);
        IntCDLL.append(16);
        IntCDLL.display();
        IntCDLL.delete(8);
        IntCDLL.display();
    }
}

/*
                    //Big-O Time complexity Answers

    1. The worst-case time complexity of the append function  O(1)
       because it directly accesses tail with constant time
       
    2. The worst-case time complexity of the delete function is O(n) n numdber of nodes 
       it can be go through the entire list
       
       
    3. The worst-case time complexity of the display function is O(n) because it must 
       go for all nodes on the list to print on screen

*/
	

