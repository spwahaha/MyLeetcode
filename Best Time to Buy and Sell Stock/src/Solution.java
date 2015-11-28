
public class Solution {
    public static int maxProfit(int[] prices) {
    	// at most one transaction, the maximal profit should be 
    	// the difference between maximal element and the minimal element 
    	
        int len = prices.length;
        int curmax = 0;
        int max = 0;
        int min = Integer.MAX_VALUE;// the minimal element in the array
    	for(int i = 1; i < len; i++){
    		min = Math.min(min, prices[i-1]);// get the minimal element in the first i elements
    		curmax = prices[i] - min;
    		max = Math.max(max, curmax);
    	}
    	return max;
    }
    
    public static void main(String[] args){
    	int[] nums = {2,1,3,5,7,6};
    	System.out.println(maxProfit(nums));
     }
}
