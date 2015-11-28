
public class Solution {
    public int rob(int[] nums) {
        int len = nums.length;
        if(len == 0) return 0;
        if(len == 1) return nums[0];
        
        int[] val = new int[len];
        val[0] = nums[0];
        val[1] = Math.max(nums[0], nums[1]);
        
        for(int i = 2; i < len; i++){
        	val[i] = Math.max(nums[i] + val[i-2], val[i-1]);
        }
    	
    	return val[len-1];
    }
    
	public static void main(String[] args){
		int[] nums = {2,3,4,5,6,7};
		Solution so = new Solution();
		System.out.println(so.rob(nums));
	}
}
