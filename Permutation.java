


	public class Permutation {

	    
	//  function to generate  permutations of a  given string 
	    public static void doPermutations(String str, String result) {
	    	
	    	
	        if (str.length() == 0) {
	        	 
	            System.out.println(result);
	            return;
	        }
	        
	        

	        for (int i = 0; i < str.length(); i++) {
	        	
	            char ch = str.charAt(i);
	            
	            String remaining = str.substring(0, i) + str.substring(i + 1);
	            
	            // recursion
	            doPermutations(remaining, result + ch);
	        }
	    }
	    
	    
	    
// main function to implement test cases
	    public static void main(String[] args) {
	        
	        String input = "AGU";
	        
	        System.out.println("Permutations  " + input);
	        
	        
	        // calling function
	       doPermutations(input, "");
	       
	    }
	}
