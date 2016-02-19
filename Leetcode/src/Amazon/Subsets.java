package Amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {
	//DFS
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums == null || nums.length == 0){
            return res;
        }
        Arrays.sort(nums);
        helper(res, nums, new ArrayList<Integer>(), 0);
        return res;
    }
    
    private void helper(List<List<Integer>> res, int[] nums, List<Integer> list, int start){
        res.add(new ArrayList<Integer>(list));
        for(int i = start; i < nums.length; i++){
            list.add(nums[i]);
            helper(res, nums, list, i + 1);
            list.remove(list.size() - 1);
        }
    }
    
    //use 0 and 1 to present whether have this element. iterative without dup
    public List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums == null || nums.length == 0){
            return res;
        }
        Arrays.sort(nums);
        int setNumber = (int)Math.pow(2, nums.length);
        for(int i = 0; i < setNumber; i++){
            res.add(new ArrayList<Integer>());
        }
        for(int i = 0; i < nums.length; i++){
            for(int j = 0; j < setNumber; j++){
                if(((j>>i)&1)==1){
                    res.get(j).add(nums[i]);
                }
            }
        }
        return res;
    }
    
    // construct new set based on the previous one
    public List<List<Integer>> subsets3(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums == null || nums.length == 0){
            return res;
        }
        Arrays.sort(nums);
        int size = 0;
        res.add(new ArrayList<Integer>());
        for(int i = 0; i < nums.length; i++){
            size = res.size();
            for(int j = 0; j < size; j++){
                List<Integer> list = new ArrayList<Integer>(res.get(j));
                list.add(nums[i]);
                res.add(list);
            }
        }
        
        return res;
    }
    
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums == null || nums.length == 0){
            return res;
        }
        Arrays.sort(nums);
        helper2(res, nums, new ArrayList<Integer>(), 0);        
        return res;
    }
    
    private void helper2(List<List<Integer>> res, int[] nums, List<Integer> list, int start){
    	res.add(new ArrayList(list));
    	for(int i = start; i < nums.length; i++){
    		if(i != start && nums[i] == nums[i - 1]){
    			continue;
    		}
    		list.add(nums[i]);
    		helper2(res, nums, list, i + 1);
    		list.remove(list.size() - 1);
    	}
    }
    
    
    
    // Iterative with duplicates
    public List<List<Integer>> subsetsWithDup2(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums == null || nums.length == 0){
            return res;
        }
        Arrays.sort(nums);
        int size = 0;
        res.add(new ArrayList<Integer>());
        for(int i = 0; i < nums.length; i++){
            int startIndex = 0;
            if(i != 0 && nums[i] == nums[i - 1]){
                startIndex = size;
            }
            size = res.size();
            for(int j = startIndex; j < size; j++){
                List<Integer> list = new ArrayList<Integer>(res.get(j));
                list.add(nums[i]);
                res.add(list);
            }
        }
        
        return res;
    }
    
}
