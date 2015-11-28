import java.util.*;

public class Solution1 {
    public static boolean isAnagram(String s, String t) {

    	Hashtable<Character,Integer> hs = new Hashtable<Character,Integer>();
    	for(int i =0; i<s.length();i++){
    		if(hs.containsKey(s.charAt(i)))
    			hs.put(s.charAt(i), hs.get(s.charAt(i))+1);
    		else hs.put(s.charAt(i), 1);
    	}
    	
    	for(int i =0;i<t.length();i++){
    		if(hs.containsKey(t.charAt(i))){
    			hs.put(t.charAt(i), hs.get(t.charAt(i))-1);
    			if(hs.get(t.charAt(i))==0) hs.remove(t.charAt(i));
    		}else	return false;

    	}
    	return hs.isEmpty();
        
    }
    public static void main(String[] args){
    	String s1 = "a";
    	String s2 = "a";
    	System.out.println(isAnagram(s1,s2));
    }
}
