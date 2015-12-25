import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII {
	public static List<List<Integer>> subsetsWithDup(int[] nums) {
		Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        generate(nums, res, new ArrayList<Integer>(), 0);
        return res;
    }
    
    private static void generate(int[] nums, List<List<Integer>> res, List<Integer> list, int start){
        res.add(new ArrayList<Integer>(list));
        
        if(start >= nums.length) return;
        
        for(int i = start; i < nums.length; ){
            list.add(nums[i]);
            generate(nums, res, list, i+1);
            list.remove(list.size()-1);
            i++;
            while(i <= nums.length-1 && nums[i] == nums[i-1]){
                i++;
            }
        }
    }
    
    public static void main(String[] args){
    	int[] nums = {1,2,2};
    	System.out.println(subsetsWithDup(nums));
    }
}
