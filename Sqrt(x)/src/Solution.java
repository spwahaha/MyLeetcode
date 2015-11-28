public class Solution {
    public static int mySqrt(int x) {
    	if(x == 0)
    		return 0;
        long h = 1;
        long l = 0;
        /** first we need to find a range for the root
         * 	the range can be get by [h/2, h]
         *  h can be obtained by h = h * 2
         *  then binary search to get the right one
         *  the time complexity should be O(lgn)
         * */
        for(; h*h<=x;h = h<<1){
        	if(h*h==x)
        		return (int)h;
        }

        l = h>>2;
        while(l<h){
        	long mid = l + ((h - l)>>1);
        	if((mid * mid) < x){
        		l = mid + 1;
        	}else if(mid * mid == x)
        		return (int) mid;
        	else{
        		h = mid;
        	}
        }
        
    	return (int)(l-1);
    }
    
    public static void main(String[] args){
    	System.out.println(Math.sqrt(2147395599));
    	System.out.print(mySqrt(2147395599));
    }
}