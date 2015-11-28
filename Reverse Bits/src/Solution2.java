public class Solution2 {
    // you need treat n as an unsigned value
    public static int reverseBits(int n) {
        int res = 0;
    	for(int i = 0; i < 32; i ++){
    		res = (res<<1) | (n&1); // res = res * 2 + (last==1? 1:0)
    		n = n >>1; // n = n / 2;
    	}
    	return res;
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