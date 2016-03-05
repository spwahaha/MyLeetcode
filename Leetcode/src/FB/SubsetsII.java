package FB;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class SubsetsII {
	// backtracking
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums == null || nums.length == 0){
            return res;
        }
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<Integer>();
        helper(res, list, nums, 0, new HashSet<Integer>());
        return res;
    }
    
    private static void helper(List<List<Integer>> res, List<Integer> list, int[] nums, int start, HashSet<Integer> set){
        res.add(new ArrayList<Integer>(list));
        for(int i = start; i < nums.length; i++){
            if(i != 0 && nums[i] == nums[i - 1] && !set.contains(i - 1)){
                continue;
            }
            list.add(nums[i]);
            set.add(i);
            helper(res, list, nums, i + 1, set);
            set.remove(i);
            list.remove(list.size() - 1);
        }
    }
    
    // iterative
    public static List<List<Integer>> subsetsWithDup2(int[] nums) {
    	List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums == null || nums.length == 0){
            return res;
        }
        Arrays.sort(nums);
        res.add(new ArrayList<Integer>());
        int size = 0;
        for(int i = 0; i < nums.length; i++){
            int start = 0;
            if(i != 0 && nums[i] == nums[i - 1]){
                start = size;
            }
            size = res.size();
            for(int j = start; j < size; j++){
                List<Integer> list = new ArrayList<Integer>(res.get(j));
                list.add(nums[i]);
                res.add(list);
            }
        }
        return res;
    }
    
    public static void main(String[] args){
    	int[] nums = {1, 2, 2};
    	System.out.println(subsetsWithDup(nums));
    	System.out.println(subsetsWithDup2(nums));
    }
}
