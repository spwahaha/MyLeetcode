
public class Solution {
    public static int titleToNumber(String s) {
        int num = 0;
        for(int i =0; i < s.length()-1;i++){
        	num+=Math.pow(26, (s.length()-i-1))*(int)(s.charAt(i)-64); 
        }
        num+=(int)(s.charAt(s.length()-1)-64); 
        return num;
    }
    
    public static void main(String[] args){
    	System.out.println(titleToNumber("AAA"));
    }
}
