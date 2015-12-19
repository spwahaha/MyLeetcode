import java.util.HashMap;

public class Solution {
    public static String getHint(String secret, String guess) {
    	if(secret==null||guess==null||secret.length()!=guess.length())
    		return "0A0B";
    	
		int bull = 0;
		int cow = 0;
		int[] nums =new int[10];
    	for(int i = 0; i < secret.length();i++){
    		int num1 = secret.charAt(i)-'0';
    		int num2 = guess.charAt(i)-'0';
    		if(num1==num2){
    			bull++;
    		}
    		else{
    			if(nums[num1]-- > 0) cow++;
    			if(nums[num2]++ < 0) cow++;
    		}
    	}
    	return ""+bull+"A"+cow+"B";
    }
    
    public static void main(String[] args){
    	System.out.println(getHint("12","21"));
    }
}