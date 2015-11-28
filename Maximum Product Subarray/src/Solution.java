
public class Solution {
    public static int maxProduct(int[] nums) {
        int curmax = nums[0];
        int curmin = nums[0];
        int max = curmax;
        
        for(int i = 1; i < nums.length;i++){
        	if(nums[i]>0){
        		curmax = Math.max(curmax*nums[i], nums[i]);
        		curmin = Math.min(curmin*nums[i], nums[i]);
        	}else{
        		int temp = curmax;
        		curmax = Math.max(curmin*nums[i], nums[i]);
        		curmin = Math.min(temp*nums[i], nums[i]);
        	}
        	max = Math.max(max, curmax);
        }
        
        return max;
    }
    
    public static void main(String[] args){
    	int[] nums = {-2,-3,-4};
    	System.out.println(maxProduct(nums));
    }
}
