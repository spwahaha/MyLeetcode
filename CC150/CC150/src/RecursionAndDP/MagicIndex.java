package RecursionAndDP;

public class MagicIndex {
	
	// brute force
	public static int magicIndex(int[] nums){
		for(int i = 0; i < nums.length; i++){
			if(nums[i] == i){
				return i;
			}
		}
		return -1;
	}
	
	// binary search -- no duplicates
	public static int magicIndex2(int[] nums){
		return magicFast(nums, 0, nums.length-1);
	}
	
	private static int magicFast(int[] nums, int start, int end){
		if(start > end){
			return -1;
		}
		
		int mid = start + (end - start) / 2;
		if(nums[mid] == mid){
			return mid;
		}
		if(nums[mid] > mid){
			return magicFast(nums, start, mid-1);
		}else{
			return magicFast(nums, mid+1, end);
		}
		
	}
	
	// handle duplicates
	public static int magicIndex3(int[] nums){
		return magicFast2(nums, 0, nums.length-1);
	}
	
	private static int magicFast2(int[] nums, int start, int end){
		if(start > end){
			return -1;
		}
		
		int mid = start + (end - start) / 2;
		int midVal = nums[mid];
		if(nums[mid] == mid){
			return mid;
		}
		int s = Math.min(mid-1, nums[mid]);
		// s = mid - 1;
		int res = magicFast2(nums, start, s);
		if(res != -1) return res;
		int e = Math.max(mid+1, nums[mid]);
		// e = mid + 1
		return magicFast2(nums, e, end);
		
	}
	
	
	
	public static void main(String[] args){
		int[] nums = {-10, -5, 2, 2, 2, 3, 4, 9, 9, 12, 13};
		System.out.println(magicIndex3(nums));
	}
}
