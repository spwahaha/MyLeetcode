package Mulesoft;

import java.util.HashSet;

public class Unifind {
	public static int maxLoop(int[] nums){
		// store the 
		HashSet<Integer> visited = new HashSet<Integer>();
		int max = 0;
		for(int i = 0; i < nums.length; i++){
			if(!visited.contains(i)){
				HashSet<Integer> loop = new HashSet<Integer>();
				while(!loop.contains(nums[i])){
					loop.add(nums[i]);
					i = nums[i];
					visited.add(nums[i]);
				}
				max = Math.max(max, loop.size());
			}
		}
		return max;
	}
	
	public static void main(String[] args){
		int[] nums = {5, 4, 0, 3, 1, 6, 2};
		System.out.println(maxLoop(nums));
	}
}
