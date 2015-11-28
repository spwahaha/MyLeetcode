public class Solution2 {
    public static boolean isPalindrome(int x) {
    	StringBuilder sb = new StringBuilder(""+x);
    	
    	return sb.toString().equals(sb.reverse().toString());
    	
    }
    
    public static void main(String[] args){
    	System.out.print(isPalindrome(-2147483648));
    }
    
    
}