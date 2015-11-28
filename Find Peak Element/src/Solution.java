
public class Solution {
    public int findPeakElement(int[] nums) {
        for(int i = 0; i < nums.length;i++){
        	if(i == 0)
        		if(nums[0]>nums[1])
        			return 0;
        	if(i == nums.length-1)
        		if(nums[i]>nums[i-1])
        			return i;
        	if(nums[i]>nums[i-1] && nums[i] > nums[i+1])
        		return i;
        }
        return 0;
    }

}
