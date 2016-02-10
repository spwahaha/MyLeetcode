
public class Minimum_Size_Subarray_Sum {
    public static int minSubArrayLen(int s, int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int i = 1;
        int j = 0;
        int sum = nums[0];
        int len = Integer.MAX_VALUE;
        while(i < nums.length && j < nums.length){
            if(sum == s){
                len = Math.min(len, i-j);
                sum += nums[i];
                i++;
            }else if(sum < s){
                sum += nums[i];
                i++;
            }else{
                sum -= nums[j];
                j++;
            }
        }
        return len==Integer.MAX_VALUE?0:len;
    }
    
    public static void main(String[] args){
    	int[] nums = {2,3,1,2,4,3};
    	System.out.println(minSubArrayLen(7,nums));
    }
}
