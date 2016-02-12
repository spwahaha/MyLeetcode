package Amazon;

public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        int l = 0;
        int h = nums.length;
        while(l<=h){
            int mid = (l + h)/2;
            if(mid==0){
                if(mid==nums.length-1) return mid;
                if(nums[mid] > nums[mid+1]) return mid;
                else l = mid+1;
            }else if(mid == nums.length-1){
                if(nums[mid] > nums[mid-1]) return mid;
                else h = mid-1;
            }else if(nums[mid] > nums[mid+1] && nums[mid] > nums[mid-1]){
                return mid;
            }else if(nums[mid] < nums[mid-1]){
                h = mid-1;
            }else{
                l = mid+1;
            }
        }
        return -1;
    }
}
