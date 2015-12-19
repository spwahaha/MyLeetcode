
public class Solution {
    public static String longestPalindrome(String s) {
        s = s.replaceAll("[^a-zA-Z0-9]","");
        if(s.length()<2)
        	return s;
        int lo = 0;
        int maxlen = 0;
        for(int i = 0; i < s.length();i++){
        	int j = i; int k = i;
        	while(j>=0&&k<s.length()&&s.charAt(j)==s.charAt(k)){
        		j--;
        		k++;
        	}
        	if(maxlen<k-j-1){
        		lo = j + 1;
        		maxlen = k-j-1;
        	}
        	j=i;
        	k=i+1;
        	while(j>=0&&k<s.length()&&s.charAt(j)==s.charAt(k)){
        		j--;
        		k++;
        	}
        	if(maxlen<k-j-1){
        		lo = j + 1;
        		maxlen = k-j-1;
        	}
        	
        }
        
        return s.substring(lo,maxlen+lo);
    }
    
    public static void main(String[] args){
    	System.out.println(longestPalindrome("abb"));
    	System.out.println(Integer.parseInt("-2"));
    }
}
