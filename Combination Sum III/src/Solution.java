import java.util.ArrayList;
import java.util.List;

public class Solution {
	public List<List<Integer>> combinationSum3(int k, int n) {
        int[] nums = new int[9];
    	for(int i = 1; i<10;i++){
    		nums[i-1] = i; 
    	}
    	
    	List<List<Integer>> res=  new ArrayList<List<Integer>>();
    	List<Integer> list = new ArrayList<Integer>();
    	
    	combiSum3(res, list, nums, n, k, 0 );
    	return res;
    }
    
        private void combiSum3(List<List<Integer>> res, List<Integer> list,
    		int[] nums, int n, int k ,int level){
    	if(list.size()==k){
    		if(n==0){
    			res.add(new ArrayList(list));
    		}
    		return;
    	}
    	for(int i = level; i<nums.length;i++){
    		list.add(nums[i]);
    		combiSum3(res, list, nums, n-nums[i], k,i+1);
    		list.remove(list.size()-1);
    	}
    	
    }
        
        public static void main(String[] args){
        	int[] nums = {2,1,4,5,2};
        	Solution so = new Solution();
        	System.out.println(so.combinationSum3(3,9));

        }
}
