package FB;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {
	//backtracking
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums == null || nums.length== 0){
            return res;
        }
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<Integer>();
        helper(res, list, nums, 0);
        return res;
    }
    
    private void helper(List<List<Integer>> res, List<Integer> list, int[] nums, int start){
        res.add(new ArrayList<Integer>(list));
        for(int i = start; i < nums.length; i++){
            list.add(nums[i]);
            helper(res, list, nums, i + 1);
            list.remove(list.size() - 1);
        }
    }
    
    //iterative
    public List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums == null || nums.length == 0){
            return res;
        }
        Arrays.sort(nums);
        int plans = (int)Math.pow(2, nums.length);
        for(int i = 0; i < plans; i++){
            res.add(new ArrayList<Integer>());
        }
        for(int i = 0; i < nums.length; i++){
            for(int j = 0; j < plans; j++){
                if(((j>>i) & 1) == 1){
                    res.get(j).add(nums[i]);
                }
            }
        }
        return res;
    }
    
    
}
