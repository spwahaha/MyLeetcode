
public class Extremum {
	public static int numOfExtremum(int[] nums){
		int num = 1;
		int diff = 0;
		for(int i = 1; i < nums.length; i++){
			int diff2 = nums[i] - nums[i - 1];
			if(diff2 * diff < 0){
				num++;
				System.out.println(nums[i] + "," + i);
			}
			if(diff2 != 0){
				diff = diff2;
			}
		}
		return ++num;
	}
	
	public static void main(String[] args){
		int[] nums = {2, 2, 3, 4, 3, 3, 2, 2, 1,1,5,5};
		System.out.println(numOfExtremum(nums));
	}
}
