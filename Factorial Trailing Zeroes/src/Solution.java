public class Solution {
    public static int trailingZeroes(int n) {
    	int count = 0;
    	int i = n;
    	while( i > 1){
    		count += i/5;
    		i /= 5;
    	}  	
    	return count;
    }
    
    public static void main(String[] args){
    	System.out.print(trailingZeroes(50));
    }
}