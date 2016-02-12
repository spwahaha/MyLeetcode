package sort2;

public class Mergesort {
	public static void mergesort(int[] nums,int low, int high){
		if(low < high){
			int mid = low + (high - low)/2;
			mergesort(nums, low, mid);
			mergesort(nums, mid+1, high);
			merge(nums, low, mid, high);
		}
	}
	
	private static void merge(int[] nums,int low,int mid,int high){
		int[] au =  new int[nums.length];
		for(int i = 0; i < nums.length; i++){
			au[i] = nums[i];
		}
		
		int left = low;
		int right = mid + 1;
		int cur = left;
		while(left <=mid && right <=high){
			if(au[left] <= au[right]){
				nums[cur] = au[left];
				left++;
			}else{
				nums[cur] = au[right];
				right++;
			}
			cur++;
		}
		
		// low - mid    mid+1 - high inclusive
		// so, need left + i == mid
		// so, (i = mid - left) == diff
		// i -> 0~diff inclusive
		// if left side is sorted, then left = mid+1, 
		// the following will not be executed
		while(left <= mid){
			nums[cur++] = au[left++];
		}
	}
	
	public static void main(String[] args){
		int[] nums = {2,3,1,9,4,2,7,4};
		mergesort(nums,0,nums.length-1);
		for(int i = 0; i < nums.length; i++){
			System.out.print(nums[i] + "   ");
		}
	}
	
}
