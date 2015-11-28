public class Solution3 {
    public static boolean isPalindrome(int x) {
    	if(x<0 || x%10==0)
    		return false;
    	int y = 0;
    	while(x>y){
    		y = y * 10 + x % 10;
    		if(y==x) return true;
    		x = x / 10;
    	}
    	return x==y;
    	
    }
    
    public static void main(String[] args){
    	System.out.print(isPalindrome(1000));
    }
    
    
}