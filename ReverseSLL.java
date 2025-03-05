
// node class 

class Node {
    int data;
    Node next;
    Node prev;
    
    

    // Constructor
    Node(int data) {
    	this.prev = null;
        this.data = data;
        this.next = null;
    }
}



public class ReverseSLL {

    //  function to reverse the given singlylinked list
	
    public static Node reverse(Node head) {
    	
        if (head == null || head.next == null) {
            return head;
        }

        Node newHead = reverse(head.next);
        
        head.next.next = head;
        
        head.next = null;
        
        return newHead;
    }

    
    
    // function to print the linked list
    public static void printList(Node head) {
    	
        Node current = head;
        System.out.print("header > ");
        
        while (current != null) {
        	
            System.out.print(current.data + " > ");
            
            current = current.next;
        }
        System.out.println("null");
    }
    
    
    
    
    
// main function for test cases
    public static void main(String[] args) {
    	
    	
        // Creating linked list
        Node head = new Node(4);
        head.next = new Node(6);
        head.next.next = new Node(8);
        head.next.next.next = new Node(10);
        head.next.next.next.next = new Node(12);

        
        System.out.println("main linked List ");
        printList(head);

        
        // Reversing the linked list
        head = reverse(head);

        System.out.println("Reversed linked list ");
        printList(head);
    }
}

