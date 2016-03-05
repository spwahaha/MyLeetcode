package FB;

public class MinimumSizeSubarraySum {
    public static int minSubArrayLen(int s, int[] nums) {
        int i = 0;
        int j = 0;
        int min = Integer.MAX_VALUE;
        int sum = 0;
        while(i < nums.length && j < nums.length){
            while(i < nums.length && sum < s){
            	sum += nums[i++];
            }
            while(j < nums.length && sum >= s){
            	min = Math.min(min, i - j);
            	sum -= nums[j++];
            }
        }
        if(min == Integer.MAX_VALUE){
            min = 0;
        }
        return min;
    }
    
    public static void main(String[] args){
    	int[] nums = {1,2,3,4,5};
    	System.out.println(minSubArrayLen(11, nums));
    }
}
