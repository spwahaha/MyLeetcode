import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

public class Solution {
    public static List<List<String>> groupAnagrams(String[] strs) {
    	Hashtable<String,List<String>> hs = new Hashtable<String,List<String>>();
    	List<List<String>> res = new ArrayList<List<String>>();
    	if(strs==null||strs.length==0) return res;
    	Arrays.sort(strs);
    	for(int i = 0; i < strs.length;i++){
    		char[] ch = strs[i].toCharArray();
    		Arrays.sort(ch);;
    		String temp = String.valueOf(ch);
    		if(!hs.containsKey(temp)){
    			List<String> list = new ArrayList<String>();
    			list.add(strs[i]);
    			hs.put(temp, list);
    		}else{
    			List<String> list = hs.get(temp);
    			list.add(strs[i]);
    			hs.put(temp, list);
    		}
    	}
    	
    	
    	return new ArrayList<List<String>>(hs.values());
    }
    
    public static void main(String[] args){
    	String[] str = {"eat", "tea", "tan", "ate", "nat", "bat"};
    	System.out.println(groupAnagrams(str));
    }
}