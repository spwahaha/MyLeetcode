package SortingandSearching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Hashtable;

public class GroupAnagram {
	public static void sortAnagram(String[] strs){
		class AnagramComparator implements Comparator<String>{
			
			private String sortStr(String str){
				char[] content = str.toCharArray();
				Arrays.sort(content);
				return new String(content);
			}
			
			public int compare(String str1, String str2){
				return sortStr(str1).compareTo(sortStr(str2));
			}
		}
		
		Arrays.sort(strs, new AnagramComparator());
	}
	
		public static void sortAnagram2(String[] strs){
			Hashtable<String, ArrayList<String>> hs = new Hashtable<String, ArrayList<String>>();
			
			for(String str:strs){
				String sorted = sortStr(str);
				ArrayList<String> list = hs.get(sorted);
				if(list == null){
					list = new ArrayList<String>();
					list.add(str);
					hs.put(sorted, list);
				}else{
					list.add(str);
					hs.put(sorted, list);
				}
			}
			int i = 0;
			for(String key:hs.keySet()){
				ArrayList<String> list = hs.get(key);
				for(String str:list){
					strs[i++] = str;
				}
			}
		}
		
		private static String sortStr(String str){
			char[] content = str.toCharArray();
			Arrays.sort(content);
			return new String(content);
		}
	
	
	public static void main(String[] args){
		String[] strs = {"care", "bac", "acre", "race", "abc", "cba", "bca"};
		sortAnagram2(strs);
		for(int i = 0; i < strs.length; i++){
			System.out.print(strs[i] + "   ");
		}
	}
}
