import java.util.Hashtable;

public class Solution {
    public static int romanToInt(String s) {
    	// here is the rule: XIX 
    	// start from the last one
    	// res = X;
    	// X > I: res = res - I;
    	// I < X: res = res + X;
    	Hashtable<Character, Integer> hs = new Hashtable<Character, Integer>();
    	if(s==null||s.length()<1)
    		return 0;
    	hs.put('I', 1);
    	hs.put('V', 5);
    	hs.put('X', 10);
    	hs.put('L', 50);
    	hs.put('C', 100);
    	hs.put('D', 500);
    	hs.put('M', 1000);
    	int res = hs.get(s.charAt(s.length()-1));
    	
    	for(int i = s.length()-1; i > 0; i--){
    		int t1 = hs.get(s.charAt(i));
    		int t2 = hs.get(s.charAt(i-1));
    		if(t1>t2){
    			res -= t2;
    		}else{
    			res += t2;
    		}
    	}
    	return res;
    }
    
    public static void main(String[] args){
    	System.out.println(romanToInt("DCXXI"));
    }
}