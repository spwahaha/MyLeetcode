package Amazon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TwoSum {
	// using hashset, no dup
	public static List<List<Integer>> twoSum(int[] nums, int target){
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if(nums == null || nums.length < 2){
			return res;
		}
		HashSet<Integer> set = new HashSet<Integer>();
		for(int i = 0; i < nums.length; i++){
			if(set.contains(target - nums[i])){
				List<Integer> list = new ArrayList<Integer>();
				list.add(nums[i]);
				list.add(target - nums[i]);
				res.add(list);
			}else{
				set.add(nums[i]);
			}
		}
		return res;
	}
	
	// with duplicates
	public static List<List<Integer>> twoSum2(int[] nums, int target){
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if(nums == null || nums.length < 2){
			return res;
		}
		HashMap<Integer, Integer> map = new HashMap<Integer,Integer>();
		for(int i = 0; i < nums.length; i++){
			if(map.containsKey(nums[i])){
				map.put(nums[i], map.get(nums[i]) + 1);
			}else{
				map.put(nums[i], 1);
			}
		}
		
		HashSet<Integer> visited = new HashSet<Integer>();
		Set<Integer> keySet = map.keySet();
		for(Integer num : keySet){
			if(visited.contains(num)) continue;
			if(map.containsKey(target - num)){
				visited.add(target - num);
				addPair(res, num, map.get(num), target - num, map.get(target - num));
			}
		}
		return res;
	}
	
	private static void addPair(List<List<Integer>> res,int num1, int times1, int num2, int times2){
		List<Integer> list = new ArrayList<Integer>();
		int times = times1 * times2;
		if(num1 == num2){
			times = times1 * (times2 - 1) / 2;
		}
		list.add(num1);
		list.add(num2);
		for(int i = 0; i < times; i++){
			res.add(new ArrayList<Integer>(list));
		}
	}
	
	public static void main(String[] args){
		int[] nums = { 1,2,3,4,3,2,1,0};
		System.out.println(twoSum(nums, 12));
		System.out.println(twoSum2(nums, 4));		
	}
}
