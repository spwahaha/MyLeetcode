import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreakII {
    public static List<String> wordBreak(String s, Set<String> wordDict) {
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();
        return helper(map, s, wordDict);
    }
    
    private static List<String> helper(HashMap<String, List<String>> map, String s, Set<String> wordDict){
//        System.out.println(map.size());
    	if(map.containsKey(s)){
            return map.get(s);
        }
//        System.out.println(s);
        List<String> res = new ArrayList<String>();
        for(int i = 1; i < s.length(); i++){
            if(wordDict.contains(s.substring(0, i))){
                List<String> list = helper(map, s.substring(i), wordDict);
                for(String str : list){
                    res.add(s.substring(0, i) + " " + str);
                }
            }
        }
        if(wordDict.contains(s)) res.add(s);
        map.put(s, res);
        return res;
    }
    
    public static void main(String[] args){
    	String[] strs = {"a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"};
    	HashSet<String> set = new HashSet<String>();
    	for(String str : strs){
    		set.add(str);
    	}
    	System.out.println(wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
    			set));
    }
}
