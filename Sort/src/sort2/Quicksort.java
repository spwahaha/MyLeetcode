package sort2;

public class Quicksort {
	public static void quicksort(int[] nums, int low, int high){
		if(low<high){
			int mid = partition(nums, low, high);
			quicksort(nums, low, mid-1);
			quicksort(nums, mid, high);
		}
		
	}
	
	private static int partition(int[] nums, int low, int high){
		int pivot = nums[(low+high)/2];
		while(low <= high){
			while(nums[low] < pivot){
				low++;
			}
			
			while(nums[high]>pivot){
				high--;
			}
			
			if(low <= high){
				int temp = nums[low];
				nums[low] = nums[high];
				nums[high] = temp;
				low++;
				high--;
			}
		}
		return low;
	}
	public static void main(String[] args){
		int[] nums = {2,3,1,9,4,2,7,4};
		quicksort(nums,0,nums.length-1);
		for(int i = 0; i < nums.length; i++){
			System.out.print(nums[i] + "   ");
		}
	}
	
}
