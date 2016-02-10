package Amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
	public static List<List<Integer>> threeSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
		Arrays.sort(nums);
		for(int i = 0; i < nums.length - 2; i++){
		    if(i != 0 && nums[i] == nums[i - 1]) continue;
			int j = i + 1;
			int k = nums.length - 1;
			while(j < k){
				if(j != i + 1 && nums[j] == nums[j - 1]){
					j++;
				}else if(k != nums.length - 1 && nums[k] == nums[k + 1]){
					k--;
				}else{
					int sum = nums[i] + nums[j] + nums[k];
					if(sum < target){
						j++;
					}else if(sum > target){
						k--;
					}else{
						List<Integer> list = new ArrayList<Integer>();
						list.add(nums[i]);
						list.add(nums[j]);
						list.add(nums[k]);
						res.add(list);
						j++;
					}
				}
			}
		}
		return res;
	}
	
}
