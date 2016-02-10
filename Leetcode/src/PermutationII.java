import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationII {
    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums==null || nums.length == 0) return res;
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<Integer>();
        helper(res, list, nums, 0, new ArrayList<Integer>());
        return res;
    }
    
    private static void helper(List<List<Integer>> res, List<Integer> list, int[] nums, int level, List<Integer> visited){
        if(level == nums.length){
            if(!res.contains(list)){
                res.add(new ArrayList<Integer>(list));
            }
            return;
        }
        
        for(int i = 0; i < nums.length; i++){
            if(visited.contains(i)) continue;
            if(level == 0 && (i > 0 && nums[i] == nums[i-1])) continue;
            visited.add(i);
            list.add(nums[i]);
            helper(res, list, nums, level+1, visited);
            list.remove(list.size()-1);
            visited.remove(visited.size()-1);
        }
    }
    
    public static void main(String[] args){
    	int[] nums = {3,3,1,2,3,2,3,1};
    	System.out.println(permuteUnique(nums));
    }
}
