import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class AddDiff {
	
	public static List<List<Integer>> addDiff(int num1, int num2){
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		List<Integer> list = new ArrayList<Integer>();
		list.add(num1);
		list.add(num2);
		helper(res, list);
		return res;
 	}
	
	private static void helper(List<List<Integer>> res, List<Integer> list){
		HashSet<Integer> set = new HashSet<Integer>();
		for(int i = 0; i < list.size()-1; i++){
			int diff = Math.abs(list.get(list.size()-1) - list.get(i));
			if(!list.contains(diff)){
				set.add(diff);
			}
		}
		if(set.size()==0){
			res.add(new ArrayList<Integer>(list));
			return;
		}
		Iterator<Integer> ite = set.iterator();
		while(ite.hasNext()){
			int num = ite.next();
			list.add((Integer)num);
			helper(res,list);
			list.remove(list.size()-1);
		}
//		Object[] integar = set.toArray();
//		for(Object num: integar){
//			list.add((Integer)num);
//			helper(res,list);
//			list.remove(list.size()-1);
//		}
	}
	
	public static void main(String[] args){
		System.out.println(addDiff(5,30));
	}
}
