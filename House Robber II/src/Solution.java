
public class Solution {
    public static int rob(int[] nums) {
    	int len = nums.length;
    	// two possible subresults
    	// 1. rob the first one, then can not rob the last one
    	// 2. do not rob the first one, then can rob the last one
    	// compare two subresults and get the maximal one
        int[] fir = new int[len-1];
        fir[0] = nums[0];
        fir[1] = Math.max(nums[0], nums[1]);
        for(int i = 2; i <len-1; i++)
        	fir[i] = Math.max(fir[i-1],fir[i-2]+nums[i]);
        
        int[] last = new int[len-1];
        last[0] = nums[1];
        last[1] = Math.max(nums[1], nums[2]);
        for(int i = 2; i < len-1 ;i++)
        	last[i] = Math.max(last[i-1],last[i-2]+nums[i+1]);
        
        return Math.max(fir[len-2], last[len-2]);
        
    }
    
    public static void main(String[] args){
    	int[] nums = {1,2,3,4,5,6,7,8};
    	System.out.println(rob(nums));
    }

}
