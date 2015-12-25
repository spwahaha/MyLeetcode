package RecursionAndDP;

import java.util.ArrayList;
import java.util.List;

public class PowerSet {
	
	// recursive
	public static List<List<Integer>> getSubsets(ArrayList<Integer> set, int index){
		List<List<Integer>> res;
		if(index == set.size()){
			res = new ArrayList<List<Integer>>();
			res.add(new ArrayList<Integer>());
			return res;
		}
		res = getSubsets(set, index+1);
		int val = set.get(index);
		List<List<Integer>> newList = new ArrayList<List<Integer>>();
		for(List list:res){
			List<Integer> l = new ArrayList<Integer>(list);
			l.add(val);
			newList.add(l);
		}
		res.addAll(newList);
		return res;		
	}
	
	
	//iterative, based on whether put the element in or not
	public static List<List<Integer>> getSubsets(ArrayList<Integer> set){
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		int max = 1<<set.size();
		for(int i= 0; i < max; i++){
			List<Integer> list = convert(set, i);
			res.add(list);
		}
		return res;
	}
	
	
	private static List<Integer> convert(ArrayList<Integer> set, int i) {
		// TODO Auto-generated method stub
		int index = 0;
		List<Integer> list = new ArrayList<Integer>();
		for(int k = i; k > 0; k=k>>1){
			if((k&1)==1){
				list.add(set.get(index));
			}
			index++;
		}
		return list;
	}


	public static void main(String[] args){
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		
		System.out.println(getSubsets(list));
	}
}
