public class Solution {
    public static int[] maxSlidingWindow(int[] nums, int k) {
    	if(nums.length==0) return new int[0];
        int i = 0;
        int j = k;
        int[] a = findMax(nums,i,j-1);
        int max = a[0];
        int posi = a[1];
        int[] res = new int[nums.length-k+1];
        res[0] = max;
    	while(j<nums.length){
    		if(nums[j]>=max){
    			max = nums[j];
    			posi = k;
    		}else{
    			if(posi==1){
    				int[] temp = findMax(nums,j-k+1,j);
    				max =temp[0];
    				posi = temp[1];
    			}else{
    				posi--;
    			}
    		}
    		res[j-k+1] = max;
    		i++;
    		j++;
    	}
    	return res;
    }

	private static int[] findMax(int[] nums, int i, int j) {
		// TODO Auto-generated method stub
		
		int[] max = new int[2];
		max[0] = nums[i];// the max in window
		max[1] = i; // the postion of max in window
		for(int k = i; k <= j; k++){
			if(nums[k]>max[0]){
				max[0] = nums[k];
				max[1] = k;
			}
		}
		max[1] -= i-1;
		return max;
	}
	
	public static void main(String[] args){
		int[] a = {68,2,53,4,1,9,9,-2,3,-1,22};
		int[] res = maxSlidingWindow(a,3);
		for(int i = 0; i < res.length; i++){
			System.out.print(res[i]+",");
		}
	}
    
    
}