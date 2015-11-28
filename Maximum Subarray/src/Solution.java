
public class Solution {
    public static int maxSubArray(int[] nums) {
    	if(nums.length<=0) return 0;
        int max = nums[0];
        int curMax = 0;
        for(int i = 1; i < nums.length;i++){
        	curMax = Math.max(curMax+nums[i], 0);
        	max = Math.max(curMax, max);
        }
        
        return max;
    }
    
    public static void main(String[] args){
    	int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
    	System.out.println(maxSubArray(nums));
    }
}
