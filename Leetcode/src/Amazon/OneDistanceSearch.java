package Amazon;

public class OneDistanceSearch {
	public static int oneDistanceSearch(int[] nums, int target){
		if(nums == null || nums.length == 0){
			return -1;
		}
		int index = search(nums, target, 0, nums.length - 1);
		return index;
	}
	
	private static int search(int[] nums, int target, int start, int end){
		if(start > end){
			return -1;
		}
		int mid = start + (end - start) / 2;
		if(nums[mid] == target){
			return mid;
		}else if(Math.abs(nums[end] - nums[mid]) > Math.abs(nums[end] - target)){
			if(Math.abs(nums[start] - nums[mid]) > Math.abs(nums[start] - target)){
				int index = search(nums, target, start, mid - 1);
				if(index != -1){
					return index;
				}else{
					return search(nums, target, mid + 1, end);
				}
			}else{
				return search(nums, target, mid + 1, end);
			}
		}else{
			return search(nums, target, start, mid - 1);
		}
	}
	
	public static void main(String[] args){
		int[] nums = {4, 3, 2, 3, 4, 5, 6};
		System.out.println(oneDistanceSearch(nums, 1));
	}
}
