import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {
	 public static List<List<Integer>> subsets(int[] nums) {
	        Arrays.sort(nums);
	        List<List<Integer>> res = new ArrayList<List<Integer>>();
	        generate(nums, res, new ArrayList<Integer>(), 0);
	        return res;
	    }
	    
	    private static void generate(int[] nums, List<List<Integer>> res, List<Integer> list, int level){

	        res.add(new ArrayList<Integer>(list));
	        if(level >= nums.length){
	            return;
	        }
	        for(int i = level; i < nums.length; i++){
	            list.add(nums[i]);
	            generate(nums, res, list, i+1);
	            list.remove(list.size()-1);
	        }
	    }
	    
	    public static void main(String[] args){
	    	int[] nums = {1,2,3};
	    	System.out.println(subsets(nums));
	    }
}
