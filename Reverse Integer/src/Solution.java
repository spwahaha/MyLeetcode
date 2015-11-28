
public class Solution {
    public static int reverse(int x) {
    	boolean flag = false;
    	if(x < 0) return -reverse(-x);
    	
    	long y = 0;
    	int temp = 0;
    	while(x!=0){
    		temp = x%10;
    		x = x/10;
    		y = y*10+temp;
    	}
    	if(flag)
    		y = -y;   	
    	if(y>Integer.MAX_VALUE||y<Integer.MIN_VALUE)
    		return 0;
		return (int)y;
        
    }
    
    public static void main(String[] args){
    	System.out.println(reverse(1000000003));
    }
}
