

// creating DLL class
class DLL<E> {
	
	// node class
    static class Node<E> {
        E element;
        Node<E> next;
        Node<E> prev;

        //constructor
        public Node(E element) {
            this.element = element;
            this.next = null;
            this.prev = null;
        }
    }

    Node<E> header;
    Node<E> trailer;
    int size = 0;

    //Dll  class constructor
    public DLL() {
        header = new Node<>(null); // Sentinel node
        trailer = new Node<>(null); // Sentinel node
        header.next = trailer;
        trailer.prev = header;
    }
}


// creating DLLPositionalList class
public class DLLPositionalList<E> {
	
    DLL<E> list = new DLL<>();

    public DLL.Node<E> addFirst(E element) {
    	
        DLL.Node<E> addedNode = new DLL.Node<>(element);

        // add between header and  first node
        addedNode.next = list.header.next;
        
        addedNode.prev = list.header;
        
        list.header.next.prev = addedNode;
        
        list.header.next = addedNode;

        list.size++;
        return addedNode;
    }

    
    // method for adding element at the last
    public DLL.Node<E> addLast(E element) {
    	
        DLL.Node<E> addedNode = new DLL.Node<>(element);

        
        addedNode.prev = list.trailer.prev;
        addedNode.next = list.trailer;
        list.trailer.prev.next = addedNode;
        list.trailer.prev = addedNode;

        list.size++;
        return addedNode;
    }
    

    
    // method for add  the element  after the p element
    public DLL.Node<E> addAfter(DLL.Node<E> p, E element) {
    	
        if (p == null || p.next == null) {
           System.out.println("İnvalid ");
        }
        
        DLL.Node<E> addedNode = new DLL.Node<>(element);

       
        addedNode.next = p.next;
        addedNode.prev = p;
        p.next.prev = addedNode;
        p.next = addedNode;

        list.size++;
        return addedNode;
        
    }
    
    
 // method for add  the element  before the p element
    public DLL.Node<E> addBefore(DLL.Node<E> p, E element) {
        if (p == null || p.prev == null) {
        	System.out.println("İnvalid ");
        }

        DLL.Node<E> addedNode = new DLL.Node<>(element);

        addedNode.next = p;
        
        addedNode.prev = p.prev;
        p.prev.next = addedNode;
        
        p.prev = addedNode;

        list.size++;
        return addedNode;
    }

    // Returns the position of the first element
    public DLL.Node<E> first() {
        if (list.size == 0) {
            return null; // List is empty
        }
        return list.header.next;
    }

    
    // Returns the position of the last element
    public DLL.Node<E> last() {
        if (list.size == 0) {
            return null; 
        }
        return list.trailer.prev;
    }
    

    //method for delete  the element at the given position
    public E remove(DLL.Node<E> p) {
    	
        if (p == null || p.prev == null || p.next == null) {
            throw new IllegalArgumentException("Invalid position or node is null.");
        }

        // Unlink the node
        p.prev.next = p.next;
        p.next.prev = p.prev;

        E removedElement = p.element;

        // Clear the removed node's references
        p.next = null;
        p.prev = null;
        p.element = null;

        list.size--;
        return removedElement;
    }

    // Replaces the element at the given position with a new value
    public E set(DLL.Node<E> p, E newValue) {
        if (p == null) {
        	System.out.println("NUll list ");
        }
        
        E oldValue = p.element;
        p.element = newValue;
        return oldValue;
    }

    
    // printing the all elements in the Positional List
    
    public void printPositionalList() {
    	
    	
        DLL.Node<E> current = list.header.next;
        while (current != list.trailer) {
        	
            System.out.print(current.element + " ");
            current = current.next;
        }
        System.out.println();
    }
    
    
// main function for test cases
    public static void main(String[] args) {
    	
    	
    	// creating positionalList 
        DLLPositionalList<Integer> positionalList = new DLLPositionalList<>();

        // test cases
        positionalList.addFirst(10); 
        positionalList.addFirst(20); 
        positionalList.addFirst(30);
        positionalList.addLast(40);  

        // Print the list
        
        positionalList.printPositionalList(); // Expected: 30, 20, 10, 40

        // Remove the last element
        System.out.println("Removed element on the last " + positionalList.remove(positionalList.last())); // Expected: 40

        // Remove the first element
        System.out.println("Removed element on the first  " + positionalList.remove(positionalList.first())); // Expected: 30

        // Print the list again
        System.out.print("List after deleting ");
        positionalList.printPositionalList(); 

       
        System.out.println("First element: " + positionalList.first().element); 
        System.out.println("Last element: " + positionalList.last().element); 
    }
}



