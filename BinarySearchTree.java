
// binarysearch class that including methods

public class BinarySearchTree {
	
	
	// Node class ( inner class)
	class Node {
	    int data;
	    Node left, right;

	    // Constructor of node class
	    public Node(int data) {
	        this.data = data;
	        left  = null;
	        right =null;
	    }
	}
	
	// constructor of BinarySearchTree
	 public BinarySearchTree() {
	        
	    }

    // method of Inserting a node into the tree
    public Node insert(Node root, int element) {
    	
        if (root == null) {
        	
            return new Node(element);
            
        }

        if (element < root.data) {
        	
            root.left = insert(root.left, element);
            
        } else if (element > root.data) {
        	
            root.right = insert(root.right, element);
            
        }
        
        return root;
    }

    // method of Deleting a node from the tree
    public Node delete(Node root, int element) {
    	
        if (root == null) {
        	
            return null;
            
        }

        if (element < root.data) {
        	
            root.left = delete(root.left, element);
            
        } else if (element > root.data) {
        	
            root.right = delete(root.right, element);
            
        } else {
        	
            // node found for deleting

            
            if (root.left == null && root.right == null) {
                return null;
            }
          
            if (root.left == null) {
            	
                return root.right;
            }
            if (root.right == null) {
            	
                return root.left;
            }

           
            // finding smallest node in the right of tree--- I assigned succesor with right root
            Node successor = root.right;
            
            while (successor.left != null) {
                successor = successor.left;
            }
            
            root.data = successor.data; 
            root.right = delete(root.right, successor.data); 
            
        }
        
        return root;
        
    }
    
    
    public boolean isBST1(Node root) {
		if(root == null)
			return true ; 
		if(root.left != null && root.left.data >= root.data)
			return false;
		if(root.right != null && root.right.data <= root.data)
			return false ; 
		
		return isBST(root.left) && isBST(root.right) ; 
	}

    
    
    // function of checking if the tree is a valid BinarySearchTree or not
    public boolean isBST(Node root) {
    	
        return isBSTUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        
    }

    
     // This function checks if a tree is a binarysearchtree  by making sure each node s value is within the correct range.
    private boolean isBSTUtil(Node root, int min, int max) {
        if (root == null) {
            return true;
        }

        if (root.data <= min || root.data >= max) {
            return false;
        }

        return isBSTUtil(root.left, min, root.data) && isBSTUtil(root.right, root.data, max);
    }
    

    // method for Inorder traversal for printing the tree
    public void inOrderTraversal(Node root) {
    	
    	
        if (root != null) {
        	
            inOrderTraversal(root.left);
            
            System.out.print(root.data + " ");
            
            inOrderTraversal(root.right);
            
        }
    }

    // Main method for test cases
    public static void main(String[] args) {
    	
    	//creating binarysearchtree
        BinarySearchTree bst = new BinarySearchTree();
        
        Node root = null;

        // Creating tree that given
        root = bst.insert(root, 40);
        root = bst.insert(root, 30);
        root = bst.insert(root, 50);
        root = bst.insert(root, 25);
        root = bst.insert(root, 35);
        root = bst.insert(root, 45);
        root = bst.insert(root, 60);

        
        // Inorder traversal
        System.out.println("InOrder Traversal Of BSTree:");
        
        bst.inOrderTraversal(root);
        
        System.out.println();

       
        System.out.println("Is the tree a valid BSTree ? " + bst.isBST(root));

        
        System.out.println("Deleting node with value 30");
        
        root = bst.delete(root, 30);
        
        System.out.println(" Traversal after deletion with Inorder traversal:");
        
        bst.inOrderTraversal(root);
        
        System.out.println();

        // Test isBST function again
        System.out.println("Is the tree a valid BST after deletion? " + bst.isBST(root));
    }
}
