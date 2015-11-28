public class Solution2 {
    public static int minSubArrayLen(int s, int[] nums) {
    	int sum = 0;
    	int lo = 0;
    	int hi = 0;
    	int min = Integer.MAX_VALUE;
    	while(hi<nums.length){
    		while(sum<s&&hi<nums.length){
    			sum +=nums[hi++];
    		}
    		while(sum>=s){
    			min = Math.min(min, hi-lo);
    			sum -= nums[lo++];
    		}	
    	}
    	return min == Integer.MAX_VALUE?0:min;
    }
    
	public static void main(String[] args){
		int[] a = {2,3,1,2,4,3};
		int res = minSubArrayLen(7,a);
		System.out.print(res+",");
	}
}