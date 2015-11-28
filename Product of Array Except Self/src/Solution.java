
public class Solution {
    public int[] productExceptSelf(int[] nums) {
     	int prod = 1;
    	int[] result = new int[nums.length];
    	int count0=0;
    	for(int i=0;i<nums.length;i++){
    		if(nums[i]!=0)
    		prod*=nums[i];
    		else count0++;
    	}
    	if(count0==nums.length){
    		return result;
    	}
    	
    	for(int i=0;i<nums.length;i++){
    		if(nums[i]==0&&count0==1){
    			result[i] = prod;
    		}else if(nums[i]==0&&count0>1){
    			result[i] = 0;
    		}else if(nums[i]!=0&&count0!=0){
    			result[i] = 0;
    		}else{
    			result[i] = prod/nums[i];
    		}
    	}

    	return result;
    }
    
    public static void main(String[] args){
    	int[] nums = {0,1,2,3,4};
    	Solution so = new Solution();
    	int[] res = so.productExceptSelf(nums);
    	for(int r:res){
    		System.out.println(r);
    	}

    }
}
