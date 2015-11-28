import java.util.HashMap;

public class Solution {
    public boolean containsDuplicate(int[] nums) {
    	if(nums.length<2) return false;
    	HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
    	for(int i=0;i<nums.length;i++){
    		if(map.containsKey(nums[i])){
    			return true;
    		}else{
    			map.put(nums[i], 1);
    		}
    	}
    	return false;
        
    }
    // 2nd: sort array, nums[i]==nums[i-1]??
    
    public static void main(String[] args){
    	int[] nums = {2,1,4,5,2};
    	Solution so = new Solution();
    	System.out.println(so.containsDuplicate(nums));

    }
}
