import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
	public static List<List<Integer>> combinationSum(int[] candidates, int target){
		Arrays.sort(candidates);
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		
		List<Integer> list = new ArrayList<Integer>();
		
		combine(candidates,target,0,res,list);
		return res;
	}
	 
	private static void combine(int[] nums,int target,int start, List<List<Integer>> res, List<Integer> list ){
		if(target == 0){
//			if(!res.contains(list)){
				res.add(new ArrayList<Integer>(list));
//			}
			return;
		}else if(target<0){
			return;
		}
		
		for(int i = start; i < nums.length;i++){
			if(i>start&&nums[i-1]==nums[i]) continue;
			list.add(nums[i]);
			// each element can only be used once, so the start after i should be i+1;
			combine(nums,target-nums[i],i+1,res,list);
			list.remove(list.size()-1);
		}
	}
	
	public static void main(String[] args){
		int[] nums = {10,1,2,7,6,1,5};
		
		System.out.println(combinationSum(nums,8));
	}
}
