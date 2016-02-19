package Amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class PermutationsII {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums == null || nums.length == 0){
            return res;
        }
        Arrays.sort(nums);
        helper(res, nums, new ArrayList<Integer>(), new HashSet<Integer>());
        return res;
    }
    
    private void helper(List<List<Integer>> res,int[] nums, ArrayList<Integer> list, HashSet<Integer> set){
        if(set.size() == nums.length){
            res.add(new ArrayList<Integer>(list));
        }else{
            for(int i = 0; i < nums.length; i++){
                if(set.contains(i)){
                    continue;
                }
                if(i != 0 && nums[i] == nums[i - 1] && !set.contains(i - 1)){
                    continue;
                }
                set.add(i);
                list.add(nums[i]);
                helper(res, nums, list, set);
                list.remove(list.size() - 1);
                set.remove(i);
            }
        }
    }
}
