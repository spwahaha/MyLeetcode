
public class longest_increasing_subarray {
	public static int longestIncreasingSubArray(int[] nums){
		int max = 1;
		int cur = 1;
		
		for(int i = 1; i < nums.length; i++){
			if(nums[i]>nums[i-1]){
				cur++;
			}else{
				cur = 1;
			}
			max = Math.max(max, cur);
		}
		return max;
	}
	
	public static void main(String[] args){
		int[] nums = {1,0,1,2,5};
		System.out.println(longestIncreasingSubArray(nums));
	}
}
