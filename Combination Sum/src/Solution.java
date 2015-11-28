import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
	 public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		List<Integer> list = new ArrayList<Integer>();
		Arrays.sort(candidates);
		helper(res, list, 0, candidates, target);
		 
		 return res;
		 
	 }

	private void helper(List<List<Integer>> res, List<Integer> list, int start, int[] candidates, int target) {
		// TODO Auto-generated method stub
		if(target==0){
			res.add(new ArrayList<Integer>(list));
			return;
		}
		if(target<0) 
			return;
		
		for(int i = start; i < candidates.length;i++){
			list.add(candidates[i]);
			// since each element can be used multiple times,
			// after insert i, we still start from i, so i can be insert
			// multiple times if necessary
			helper(res,list,i,candidates,target-candidates[i]);
			list.remove(list.size()-1);
		}
	}
}
