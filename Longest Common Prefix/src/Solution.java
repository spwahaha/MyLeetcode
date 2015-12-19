public class Solution {
    public static String longestCommonPrefix(String[] strs) {
    	if(strs==null||strs.length<1)
    		return "";
        int res = 0;
    	for(int i = 0; i < strs[0].length();i++){
    		char common = strs[0].charAt(i);
    		for(String str:strs){
    			if(str.length()<=i||str.charAt(i)!=common)
    		    	return strs[0].substring(0, res);
    		}
			res++;
    	}
    	return strs[0];
    }
    
    public static void main(String[] args){
    	String[] strs = new String[3];
    	strs[0] = "000";
    	strs[1] = "000";
    	strs[2] = "0000";
    	System.out.println(longestCommonPrefix(strs));
    }
    
    
}