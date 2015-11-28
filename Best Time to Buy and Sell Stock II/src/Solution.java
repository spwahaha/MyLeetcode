
public class Solution {
    public int maxProfit(int[] prices) {
        int len = prices.length;
    	if(len == 0) return 0;
    	if(len == 1) return 0;
    	int[] pr = new int[len];
    	pr[0] = 0;
    	// if you price[i] > prices[i-1] you make the deal and get more profit
    	for(int i = 1; i < len; i++)
    		pr[i] = Math.max(pr[i-1], pr[i-1] + prices[i] - prices[i-1]);
    	return pr[len-1];
    }
    
    public static void main(String[] args){
    	Solution so = new Solution();
    	int[] nums = {2,3,1,4,5};
    	System.out.println(so.maxProfit(nums));
    }
}
