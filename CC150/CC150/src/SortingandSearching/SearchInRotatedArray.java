package SortingandSearching;

public class SearchInRotatedArray {
	public static int search(int[] nums, int start, int end, int target){
		if(end < start) return -1;
		int mid = (start + end) / 2;
		if(nums[mid] == target){
			return mid;
		}
		if(nums[mid] < nums[end]){
			//right is sorted
			if(target > nums[mid] && target <= nums[end]){
				return search(nums, mid+1, end,target);
			}else{
				return search(nums, start, mid-1, target);
			}
		}else if(nums[start] < nums[mid]){
			// left is sorted
			if(target >= nums[start] && target < nums[mid]){
				return search(nums, start, mid-1, target);
			}else{
				return search(nums, mid+1, end, target);
			}
		}else{ // handle the duplicates situation
			// left or right repeats
			if(nums[mid]!=nums[end]){
				//right sorted
				return search(nums, mid+1, end, target);
			}else if(nums[mid]!=nums[start]){
				// left sorted
				return search(nums, start, mid-1,target);
			}else{
				// can't determine
				int res = search(nums, start, mid-1, target);
				if(res!=-1) return res;
				else{
					return search(nums, mid, end-1, target);
				}
			}
		}
		
	}
	
	
	
	
	public static void main(String[] args){
		int[] nums = {6,7,5,5,5,5,5};
		System.out.println(search(nums, 0, nums.length-1, 6));
		
	}
	
}
