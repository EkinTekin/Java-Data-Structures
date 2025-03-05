





public class SinglyLinkedList<T> {
    private Node<T> head;

    // node Class 
    private static class Node<T> {
        T data;
        Node<T> next;

        // Constructor to initialize node with data
        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    // constructor to initialize empty SinglyLinkedList
    
    
    public SinglyLinkedList() {
        this.head = null;
    }

    // function to append a node at the end
    
    
    public void append(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
        } else {
            Node<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    // function to delete the first node with the given value
    
    
    public void delete(T data) {
    	
    	// list is empty
    	
        if (head == null) return; 
        
        // if the head node contains  data to be deleted
        
        if (head.data.equals(data)) {
            head = head.next;
            return;
        }

        Node<T> current = head;
        while (current.next != null && !current.next.data.equals(data)) {
            current = current.next;
        }

        // if the node is found delete it
  
        if (current.next != null) {
            current.next = current.next.next;
        }
    }

    // function to display the list 
    
    public void display() {
        Node<T> current = head;
        while (current != null) {
            System.out.print(current.data +" ");
            current = current.next;
        }
        System.out.println("null");
    }



    public static void main(String[] args) {
        
    	
    	// INTSLL object created in main of SinglyLinkedList Class
        SinglyLinkedList<Integer> IntSLL = new SinglyLinkedList<>();
        
        
        IntSLL.append(0);
        IntSLL.append(1);
        IntSLL.append(3);
        IntSLL.append(2);
        
        IntSLL.display(); 
        
        
        IntSLL.delete(2);
        IntSLL.display(); 

     // STRSLL object created
        
        SinglyLinkedList<String> StrSLL = new SinglyLinkedList<>();
        
        
        StrSLL.append("apple ");
        
        StrSLL.append("banana ");
        
        StrSLL.append("cherry ");
        
        StrSLL.display(); 



	}
}

/* 
Time Complexity Answers

1-Append Function "O(n)"  In the worst case traverse all the way to  end of the list to append  new node. 


2-Delete function   "O(n)"  In the worst case traverse all list to find node to delete

3-Display function  "O(n)"  traverse all list to print node
 


*/











