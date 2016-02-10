import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordLadderII {
    public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
        HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        for(String str : wordList){
            map.put(str, new ArrayList<String>());
        }
        HashMap<String, Integer> disMap = new HashMap<String, Integer>();
        Queue<String> q = new LinkedList<String>();
        q.add(beginWord);
        wordList.add(endWord);
        disMap.put(beginWord, 0);
        while(!q.isEmpty()){
            int size = q.size();
            boolean foundEnd = false;
            for(int i = 0; i < size; i++){
                String cur = q.poll();
                int dis = disMap.get(cur);
                HashSet<String> neibors = getNeighbors(cur, wordList);
                for(String nei : neibors){
                    map.get(cur).add(nei);
                    if(!disMap.containsKey(nei)){
                        disMap.put(nei, dis + 1);
                        if(nei.equals(endWord)){
                        foundEnd = true;
                        }else{
                            q.add(nei);
                        }
                    }
                }

            }
           if (foundEnd)
               break;
        }
        
        List<List<String>> res = new ArrayList<List<String>>();
        ArrayList<String> list = new ArrayList<String>();
        helper(res, map, disMap, list, beginWord, endWord);
        return res;
    }
    
    private HashSet<String> getNeighbors(String cur, Set<String> wordList){
        char[] array = cur.toCharArray();
        HashSet<String> set = new HashSet<String>();
        for(int i = 0; i < array.length; i++){
            char letter = array[i];
            for(char j = 'a'; j <= 'z'; j++){
                array[i] = j;
                String newWord = new String(array);
                if(wordList.contains(newWord)){
                    set.add(newWord);
                }
            }
            array[i] = letter;
        }
        return set;
    }
    
    private void helper(List<List<String>> res, HashMap<String, ArrayList<String>> map, HashMap<String,Integer> disMap,  ArrayList<String> list, String start, String end){
        list.add(start);
        if(start.equals(end)){
            res.add(new ArrayList<String>(list));
            list.remove(list.size() - 1);
            return;
        }
        ArrayList<String> neighbors = map.get(start);
        for(String nei : neighbors){
            if(disMap.get(nei) == disMap.get(start) + 1){
            	System.out.println(start + ",," + nei);
            	System.out.println(start + disMap.get(start));
            	System.out.println(nei + disMap.get(nei));
                helper(res, map, disMap, list, nei, end);
            }
        }
        list.remove(list.size() - 1);
    }
    
    public static void main(String[] args){
    	HashSet<String> set = new HashSet<String>();
    	String[] strs = {"hot","cog","dog","tot","hog","hop","pot","dot"};
    	for(String str : strs){
    		set.add(str);
    	}
    	WordLadderII wl = new WordLadderII();
    	System.out.println(wl.findLadders("hot", "dog",  set));
    }
    
    
}
