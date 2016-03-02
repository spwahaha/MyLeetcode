package FB;

import java.util.Arrays;

public class GetSortedQuar {
	public static int[] generate(int[] nums){
		if(nums == null || nums.length == 0){
			return new int[0];
		}
		int[] res = new int[nums.length];
		int left = 0;
		int right = nums.length - 1;
		int posi = res.length - 1;
		while(left <= right){
			if(Math.abs(nums[left]) > Math.abs(nums[right])){
				res[posi] = nums[left] * nums[left];
				left++;
			}else{
				res[posi] = nums[right] * nums[right];
				right--;
			}
			posi--;
		}
		
		return res;
	}
	
	public static void main(String[] args){
		int[] nums = {-3,-2,-1};
		System.out.println(Arrays.toString(generate(nums)));
	}
}
