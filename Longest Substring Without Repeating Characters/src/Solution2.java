import java.util.HashSet;

public class Solution2 {
    public static int lengthOfLongestSubstring(String s) {
        if(s==null||s.length()<1)
        	return 0;
        HashSet<Character> hs = new HashSet<Character>();
        int start = 0;
        int end = 0;
        int max = 0;
        while(end<s.length()){
        	if(!hs.contains(s.charAt(end))){
        		hs.add(s.charAt(end++));
        		max = Math.max(max, hs.size());
        	}else{
        		hs.remove(s.charAt(start++));
        	}
        }
        
        return max;
    }
    
    
    public static void main(String[] args){
    	System.out.println(lengthOfLongestSubstring("aab"));
    }
}
