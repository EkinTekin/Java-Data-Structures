

// Node Class. I made the name TreeNode because of it was conflict some other nodes class
class TreeNode<E> {
	
    E value;
    
    TreeNode<E> left;
    
    TreeNode<E> right;

    
    
    // Treenode constructor
    
    public TreeNode(E value) {
        this.value = value;
        this.left = null;
        this.right = null;
        
    }
}

// BinaryTree Class
class BinaryTree<E> {
	
	
    TreeNode<E> root;

    // BinaryTree constructor
    public BinaryTree() {
        root = null;
    }

    // function of preorderTraversal
    
    public void preOrderTraversal(TreeNode<E> node) {
    	
        if (node == null) return;
        System.out.print(node.value + " ");
        
        preOrderTraversal(node.left);
        
        preOrderTraversal(node.right);
    }

    
    
    // function of postorder traversal
    public void postOrderTraversal(TreeNode<E> node) {
        if (node == null) return;
        
        postOrderTraversal(node.left);
        
        postOrderTraversal(node.right);
        
        System.out.print(node.value + " ");
        
    }

    
    
    
    // this function calculating height of tree and returns its height
    public int height(TreeNode<E> node) {
        if (node == null) 
        	return 0;
        int leftHeight = height(node.left);
        
        int rightHeight = height(node.right);
        
        
        return Math.max(leftHeight, rightHeight) + 1;
    }
    

    // finding elements on the tree and returns true or false
    
    public boolean find(TreeNode<E> node, E element) {
    	
        if (node == null) return false;
        
        if (node.value.equals(element)) return true;
        
        return find(node.left, element) || find(node.right, element);
        
    }
    

    // main function for test cases
    
    public static void main(String[] args) {
    	
    	
    	
    	//creating tree
        BinaryTree<Integer> tree = new BinaryTree<>();
        tree.root = new TreeNode<>(1);
        tree.root.left = new TreeNode<>(2);
        tree.root.right = new TreeNode<>(3);
        tree.root.left.left = new TreeNode<>(4);
        tree.root.left.right = new TreeNode<>(5);
        tree.root.right.left = new TreeNode<>(6);
        tree.root.right.right = new TreeNode<>(7);
        tree.root.left.right.left = new TreeNode<>(8);
        tree.root.left.right.right = new TreeNode<>(9);
        
        
        // test cases
        System.out.print("Preorder Traversal ");
        tree.preOrderTraversal(tree.root);
        System.out.println();

        
        
        
        System.out.print("Postorder Traversal ");
        
        tree.postOrderTraversal(tree.root);
        System.out.println();

       
        System.out.println("Height of Tree " + tree.height(tree.root));

        System.out.println("Find 13 >" + tree.find(tree.root, 13)); 
        System.out.println("Find 3 > " + tree.find(tree.root, 3)); 
        
    }
}

