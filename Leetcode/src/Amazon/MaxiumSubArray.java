package Amazon;

public class MaxiumSubArray {
	//Greedy
    public int maxSubArray(int[] nums) {
        int cur = 0;
        int max = nums[0];
        for(int i = 0; i < nums.length; i++){
            cur += nums[i];
            max = Math.max(cur, max);
            cur = Math.max(cur, 0);
        }
        return max;
    }
    
    //DP
    public int maxSubArray2(int[] nums) {
    	int[] f = new int[nums.length];
    	f[0] = nums[0];
        int max = nums[0];
        for(int i = 1; i < nums.length; i++){
            f[i] = Math.max(f[i - 1] + nums[i], nums[i]);
            max = Math.max(max, f[i]);
        }
        return max;
    }
}
