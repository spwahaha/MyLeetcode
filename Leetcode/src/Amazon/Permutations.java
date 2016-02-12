package Amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Permutations {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res  = new ArrayList<List<Integer>>();
    	if(nums == null || nums.length == 0){
    		return res;
    	}
    	
    	Arrays.sort(nums);
    	helper(res, new ArrayList<Integer>(),nums, 0, new HashSet<Integer>());
    	return res;
    }
    
    private void helper(List<List<Integer>> res, ArrayList<Integer> list, int[] nums, int level, HashSet<Integer> visited){
        if(level == nums.length){
            res.add(new ArrayList<Integer>(list));
            return;
        }
        for(int i = 0;i < nums.length; i++){
            if(visited.contains(i)){
                continue;
            }
            if(i > 0 && nums[i] == nums[i - 1] && !visited.contains(i - 1)){
                continue;
            }
                visited.add(i);
                list.add(nums[i]);
                helper(res, list, nums, level + 1, visited);
                visited.remove(i);
                list.remove(list.size() - 1);
        }
    }
}
