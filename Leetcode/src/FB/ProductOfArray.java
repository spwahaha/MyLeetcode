package FB;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ProductOfArray {
	public static List<Integer> getProduct(int[] nums){
		List<Integer> res = new ArrayList<Integer>();
		if(nums == null || nums.length == 0){
			return res;
		}
		Arrays.sort(nums);
		helper(res, nums, 1, 0, 0);
		Collections.sort(res);
		return res;
	}
	
	private static void helper(List<Integer> res, int[] nums, int prod, int level, int start){
		if(level != 0){
			res.add(prod);
		}
		for(int i = start; i < nums.length; i++){
			helper(res, nums, prod * nums[i], level + 1, i + 1);
		}
	}
	
	public static void main(String[] args){
		int[] nums = {2, 3, 4, 5};
		System.out.println(getProduct(nums));
	}
}
