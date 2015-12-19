import java.util.HashSet;

public class Solution3 {
    public static int lengthOfLongestSubstring(String s) {
        if(s==null||s.length()<1)
        	return 0;
        int start = 0;
        int end = 0;
        int max = 0;
        boolean[] ch = new boolean[256];
        while(end<s.length()){
        	char c = s.charAt(end);
        	if(!ch[s.charAt(end)]){
        		ch[c]=true;
        		end++;
        		max = Math.max(max, end-start);
        	}else{
        		ch[s.charAt(start)] = false;
        		start++;
        	}
        }
        
        return max;
    }
    
    
    public static void main(String[] args){
    	System.out.println(lengthOfLongestSubstring("  "));
    }
}
