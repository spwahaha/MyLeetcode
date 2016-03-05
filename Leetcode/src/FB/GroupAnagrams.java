package FB;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<List<String>>();
        if(strs == null || strs.length == 0){
            return res;
        }
        Arrays.sort(strs);
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();
        for(String str : strs){
            char[] cAr = str.toCharArray();
            Arrays.sort(cAr);
            String key = new String(cAr);
            if(map.containsKey(key)){
                map.get(key).add(str);
            }else{
                List<String> list = new ArrayList<String>();
                list.add(str);
                map.put(key, list);
            }
        }
        
        Set<String> set = map.keySet();
        for(String str : set){
            res.add(map.get(str));
        }
        return res;
    }
}
