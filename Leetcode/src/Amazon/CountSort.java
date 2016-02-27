package Amazon;

import java.util.Random;

public class CountSort {
	public static void countSort(int[] nums){
		int[] cnt = new int[10];
		for(int num : nums){
			cnt[num]++;
		}
		int index = 0;
		for(int i = 0; i < cnt.length; i++){
			for(int j = 0; j < cnt[i]; j++){
				nums[index++] = i;
			}
		}
	}
	
	public static void main(String[] args){
		int[] nums = new int[100];
		Random rand = new Random();
		for(int i = 0; i < nums.length; i++){
			nums[i] = rand.nextInt(10);
		}
		countSort(nums);
		for(int i = 0; i < nums.length; i++){
			System.out.print(nums[i] + ",");
		}
		
	}
}
