package Amazon;

public class FindMinimuminRotatedSortedArray {
    public int findMin(int[] nums) {
        if(nums == null || nums.length == 0){
            return -1;
        }
        int start = 0;
        int end = nums.length - 1;
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(nums[mid] <= nums[end]){
                if(mid == start || nums[mid - 1] > nums[mid]){
                    return nums[mid];
                }else{
                    end = mid - 1;
                }
            }else{
                start = mid + 1;
            }
        }
        return -1;
    }
    
    public int findMin2(int[] nums) {
        if(nums == null || nums.length == 0){
            return -1;
        }
        int target = nums[nums.length -1];
        int start = 0;
        int end = nums.length - 1;
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(nums[mid] <= target){
                if(mid == start || nums[mid - 1] > nums[mid]){
                    return nums[mid];
                }else{
                    end = mid - 1;
                }
            }else{
                start = mid + 1;
            }
        }
        return -1;
    }
    
    //duplicates
    public int findMin3(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(nums[mid] <= nums[end]){
                if(mid == start || nums[mid - 1] > nums[mid]){
                    return nums[mid];
                }else{
                    end--;
                }
            }else{
                start = mid + 1;
            }
        }
        return -1;
    }
}
