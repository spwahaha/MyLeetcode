package Amazon;

public class OccurancesInSortedArray {
	public int totalOccurrence(int[] nums, int target) {
        // Write your code here
        if(nums == null || nums.length == 0){
            return 0;
        }
        if(target < nums[0] || target > nums[nums.length - 1]){
            return 0;
        }
        
        int start = 0;
        int end = nums.length - 1;
        int left = -1;
        int right = -1;
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(nums[mid] == target){
                if(mid == start || nums[mid - 1] != target){
                    left = mid;
                    break;
                }else{
                    end = mid - 1;
                }
            }else if(target < nums[mid]){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        if(left == -1) return 0;
        start = 0;
        end = nums.length - 1;
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(nums[mid] == target){
                if(mid == end || nums[mid + 1] != target){
                    right = mid;
                    break;
                }else{
                    start = mid + 1;
                }
            }else if(target < nums[mid]){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        if(left == -1 || right == -1){
            return 0;
        }
        return right - left + 1;
    }
}
