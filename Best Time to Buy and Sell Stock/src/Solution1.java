
public class Solution1 {
    public static int maxProfit(int[] prices) {
    	
    	// pr[i] - pr[0] = pr[i] - pr[i-1] + pr[i-1] - pr[i-2]
    	//               =... + pr[1] - pr[0]
    	// when pr[i] - pr[0] <=0, pr[i] is the minimal element so far,
    	// so, start from pr[i]
    	
        int len = prices.length;
        int curmax = 0;
        int max = 0;
    	for(int i = 1; i < len; i++){
    		curmax = Math.max(curmax+prices[i]-prices[i-1],0 );
    		max = Math.max(curmax, max);
    	}
    	return max;
    }
    
    public static void main(String[] args){
    	int[] nums = {1,2,3,4,3,0,1,7,6};
    	System.out.println(maxProfit(nums));
     }
}
