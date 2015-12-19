import java.util.HashSet;
import java.util.Hashtable;

public class Solution {
    public static int lengthOfLongestSubstring(String s) {
        if(s==null||s.length()<1)
        	return 0;
        int start = 0;
        int end = 1;
        int max = 0;
        while(end<=s.length()){
        	String temp = s.substring(start, end);
        	if(valid(temp)){
        		max = Math.max(max, end-start);
        		end++;
        	}
        	else{
        		start++;
        	}
        }
        return max;
    }
    
    private static boolean valid(String s){
    	HashSet<Character> hs = new HashSet<Character>();
    	for(Character c:s.toCharArray()){
    		if(hs.contains(c))
    			return false;
    		hs.add(c);
    	}
    	return true;
    }
    
    public static void main(String[] args){
    	System.out.println(lengthOfLongestSubstring("  "));
    }
}