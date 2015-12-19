public class Solution {
    public static String convert(String s, int numRows) {
    	if(numRows<1)
    		return null;
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        for(int i = 0; i < numRows;i++ ){
        	if(i == 0|| i == numRows-1){
        		for(int j=i; j < n;){
        			sb.append(s.charAt(j));
        			j += 2*(numRows-1);
        		}
        	}else{
        		for(int j = i; j < n;){
        			sb.append(s.charAt(j));
        			j += 2*(numRows-1-i);
        			if(j<n){
        				sb.append(s.charAt(j));
        			}
        			j += 2*(i);
        		}
        	}
        }
        return sb.toString();
    }
    
    public static void main(String[] args){
    	System.out.println(convert("abcdefghijklmnopqrs",4));
    }
}