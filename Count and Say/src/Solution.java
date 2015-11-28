
public class Solution {
    public static String countAndSay(int n) {
        if(n<1) return "";
        String str = "1";
        for(int i = 2;i<=n; i++){
            str = helper(str,"");
        }
        return str;
    }
    private static String helper(String str, String res){
    	// construc the say by grammar
        if(str.length()==0)
            return res;
        int i=1;
     // get the repeated times of charAt(0)
        for(;i<(str.length());i++){
            if(str.charAt(i-1)!=str.charAt(i))
                break;
        }
     // get the first part of the repeated string
        res += ""+i+str.charAt(0);
     // go the the next part and update string using same grammar
        return helper(str.substring(i),res);
        
    }
    
    public static void main(String[] args){
    	System.out.println(countAndSay(5));
    }
}
