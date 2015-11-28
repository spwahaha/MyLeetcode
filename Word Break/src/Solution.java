import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static boolean wordBreak(String s, Set<String> wordDict) {
        int len = s.length();
        boolean[] dp = new boolean[len+1];
        
        dp[0] = true;
        
        for(int i = 0; i < len+1;i++)
        	for(int j = 0; j <i; j++){
        		if(dp[j]&&wordDict.contains(s.substring(j,i))){
        			dp[i] = true;
        			break;
        		}

        	}
        return dp[len];
    	
    }
    
    public static void main(String[] args){
    	Set<String> set = new HashSet<String>();
    	set.add("leet");
    	set.add("code");
    	set.add("come");
    	set.add("here");
    	System.out.println(wordBreak("comehereleetcode",set));
    }
}
