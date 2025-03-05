
public class ArrayStack {
	
	private Integer[] stack;
	private int top;
	private int capacity;
	
	// constructor for ArrayStack class
	public ArrayStack(int size) {
		
		stack = new Integer[size];
		capacity=size;
		top=-1;
	
	}
	
	// method for deleting elements in stack
		 public Integer pop() {
			 
			 if (isEmpty()) {
		            
		            return -1;
		            
		        }
			 
		        return stack[top--];
		 }
		 
		 
	// method for adding element on the stack
	 public void push(Integer element) {
		 
	        if (top == capacity - 1) {
	        	
	            
	            return;
	        }
	        
	        stack[++top] = element;
	    }
	
	 
	 
	
	 // method for return the size of stack
	 public int size() {
	        return top + 1;
	    }

	 
	    // method for the check if the stack is empty
	    public boolean isEmpty() {
	        return top == -1;
	    }

	    
	    
	    // method to print the elements 
	    public void printStack() {
	        if (isEmpty()) {
	            System.out.println("no elements to print");
	            return;
	        }
	        
	        for (int i = 0; i <= top; i++) {
	        	
	            System.out.print(stack[i] + " ");
	            
	        }
	        System.out.println();
	    }
	
	
	
	
	
// main function for test cases
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        
		//  creating stack
		ArrayStack stack = new ArrayStack(10);
		
		stack.push(10);
		stack.push(20);
		stack.push(30);
		stack.push(40);
		stack.printStack();
		
		stack.pop();
		
		stack.printStack();

		System.out.println(stack.size() + " Size of stack");
		
		System.out.println(stack.isEmpty() + " Booelan result");
		
		
		
		
	}

}
