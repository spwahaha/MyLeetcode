import java.util.HashMap;

public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
    	if(nums.length<2) return false;
    	HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();
    	for(int i=0;i<nums.length;i++){
    		if(map.containsKey(nums[i])){
    			if(i-map.get(nums[i])<=k){
    				return true;
    			}else{
    				//put the latest location 
    				map.put(nums[i], i);
    			}
    		}else{
    			map.put(nums[i], i);
    		}
    	}
    	return false;
    }
    
    public static void main(String[] args){
    	Solution so = new Solution();
    	int[] nums = {0,1,2,3,5,6,3,9};
    	int k = 3;
    	System.out.println(so.containsNearbyDuplicate(nums,k));
    }
}
