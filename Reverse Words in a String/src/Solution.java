public class Solution {
    public static String reverseWords(String s) {
        if(s ==null)
            return null;
        s = s.trim();
        if(s.equals(""))
            return "";
        String[] strs = s.split(" ");
        for(int i = strs.length-1; i >= 0; i--){
            strs[i] = strs[i].trim();
        }
        StringBuilder sb = new StringBuilder();
        for(int i = strs.length-1; i >= 0; i--){
        	if(!strs[i].equals("")){
                if(i!=strs.length-1)
                    sb.append(" ");
                sb.append(strs[i]);
        	}
        }
        return sb.toString();
    }
    
    public static void main(String[] args){
    	System.out.println(reverseWords("   a   b "));
    }
}