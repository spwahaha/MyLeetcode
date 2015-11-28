
public class Solution {
    public static boolean canJump(int[] nums) {
    	if(nums.length==0) return false;
    	if(nums.length ==1) return true;
    	int maxR = 0;
        for(int i = 0; i<nums.length&&i<=maxR;i++){
        	maxR = Math.max(maxR, nums[i]+i);
        }
        return maxR>=nums.length-1;
    }
    
    public static void main(String[] args){
    	int[] nums = {2,0,0};
    	
    	System.out.println(canJump(nums));
    }
}
