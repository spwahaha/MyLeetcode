package Amazon;

public class KthLargestNumber {
	public static int findKthLargest(int[] nums, int k){
		int low = 0;
		int high = nums.length - 1;
		while(low <= high){
			int j = partition(nums, low, high);
			if(j == nums.length - k){
				return nums[j];
			}else if(j > nums.length - k){
				high = j - 1;
			}else{
				low = j + 1;
			}
		}
		
		return -1;
	}
	
	private static int partition(int[] nums, int low, int high){
		int num = nums[low];
		int i = low + 1;
		int j = high;
		while(true){
			while(i < high && nums[i] <= num){
				i++;
			}
			while(j > low && nums[j] >= num){
				j--;
			}
			if(i >= j) break;
			int temp = nums[i];
			nums[i] = nums[j];
			nums[j] = temp;
		}
		
		int temp = nums[low];
		nums[low] = nums[j];
		nums[j] = temp;
		return j;
	}
	
	public static void main(String[] args){
		int[] nums = {1,1,2,3,4,0,-1,0};
		System.out.println(findKthLargest(nums, 2));
	}
}
