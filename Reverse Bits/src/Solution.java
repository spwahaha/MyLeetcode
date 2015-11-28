public class Solution {
    // you need treat n as an unsigned value
    public static int reverseBits(int n) {
        long res = 0;// take care of the out of int scope
    	for(int i = 0; i < 32; i ++){
    		res += Math.pow(2, 31-i) * (n&1);
    		n = n >>1;
    	}
    	return (int)res;
    }
    
    public static void main(String[] args){
    	assert(Integer.reverse(5)==reverseBits(5));
    	assert(Integer.reverse(123)==reverseBits(123));
    	assert(Integer.reverse(231)==reverseBits(231));
    	assert(Integer.reverse(231)==reverseBits(231));
    	assert(Integer.reverse(5231)==reverseBits(5231));
    	assert(Integer.reverse(92812)==reverseBits(92812));
    	System.out.println(reverseBits(1));
    	System.out.println(4>>1);
    	System.out.println(4>>1);
    	
    }
}