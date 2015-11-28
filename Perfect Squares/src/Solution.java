
public class Solution {
    public static int numSquares(int n) {
        int[] number =new int[n+1];
        number[0] = 0;
        
        for(int i = 1;i<=n;i++){
        	int min = Integer.MAX_VALUE;
        	for(int j=1; j*j <= i;j++){
        		min = Math.min(min, number[i-j*j]+1);
        	}
        	number[i] = min;
        } 
        
        return number[n];
    }
    
    public static void main(String[] args){
    	System.out.println(numSquares(12));
    }
}
