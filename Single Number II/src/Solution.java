import java.util.Arrays;

public class Solution {
    public static int singleNumber(int[] nums) {
        Arrays.sort(nums);
        if(nums[0]!=nums[1])
        	return nums[0];
        for(int i = 0;i<nums.length/3;i++){
        	if(nums[3*i]!=nums[3*i+1])
        		return nums[3*i];
        }
        return nums[nums.length-1];
    }
    
    public static void main(String[] args){
    	int[] nums = {0,0,0,1,1,1,2,2,2,4};
    	System.out.println(singleNumber(nums));
    }
}
