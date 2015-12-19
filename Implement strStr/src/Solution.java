
	public class Solution {
	    public static int strStr(String haystack, String needle) {
	        if(haystack==null||needle==null)
	            return -1;
	        if(needle.equals(""))
	            return 0;
	        int m = haystack.length();
	        int n = needle.length();
	        for(int i = 0; i <= m-n;i++){
	            if(haystack.substring(i,i+n).equals(needle))
	            	return i;
	        }
	        return -1;
	    }
	    
	    public static void main(String[] args){
	    	System.out.println(strStr("aaa","a"));
	    }
	}

