
public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int sum = 0;
    	int min = Integer.MAX_VALUE;
    	int i=0;
    	int j=0;
    	// i and j define the range
    	while(i<nums.length){
        	while(sum<s&&i<nums.length){
        		sum+=nums[i++];
        	}
    		while(sum>=s){
    			sum-=nums[j++];
                min = Math.min(min, i-j+1);
    		}

    	}

    	return min==Integer.MAX_VALUE?0:min;
    }
    
    public static void main(String[] args){
    	Solution so = new Solution();
    	int[] nums = {0,1,2,3,5,6,8,9};
    	System.out.println(so.minSubArrayLen(5,nums));
    }
}
