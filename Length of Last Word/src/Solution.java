public class Solution {
    public int lengthOfLastWord(String s) {
    	if(s==null||s.length()<1)
    		return 0;
        String[] strs = s.split(" ");
        return strs[strs.length-1].length();
    }
    public static void main(String[] args){
    	String s = "   ";
    	String[] strs = s.split(" ");
    	System.out.println("asd");
    }
}