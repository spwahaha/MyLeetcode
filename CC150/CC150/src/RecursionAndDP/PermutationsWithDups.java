package RecursionAndDP;

import java.util.ArrayList;
import java.util.Hashtable;

public class PermutationsWithDups {
	public static ArrayList<String> getPerms(String str){
		ArrayList<String> res = new ArrayList<String>();
		Hashtable<Character, Integer> map = getFreq(str);
		helper(res, map, "", str.length());
		return res;
	}
	
	
	private static Hashtable<Character,Integer> getFreq(String str){
		Hashtable<Character, Integer> map = new Hashtable<Character, Integer>();
		for(int i = 0; i < str.length(); i++){
			Character c = str.charAt(i);
			Integer v = map.get(c);
			if(v!=null){
				map.put(c, map.get(c) + 1);
			}else{
				map.put(c,1);
			}
		}
		return map;
	}
	
	private static void helper(ArrayList<String> res,
		Hashtable<Character, Integer> map, String prefix, int reminder){
			if(reminder==0){
				res.add(prefix);
				return;
			}
			
			for(Character c: map.keySet()){
				int count = map.get(c);
				if(count > 0){
					map.put(c, count-1);
					helper(res, map, prefix+c, reminder-1);
					map.put(c, count);
				}
			}
		}
		
	public static void main(String[] args){
		System.out.println(getPerms("aaaaaaab"));
	}
}
