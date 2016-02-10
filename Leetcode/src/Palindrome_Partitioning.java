import java.util.ArrayList;
import java.util.List;

public class Palindrome_Partitioning {
    public static List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<List<String>>();
        if(s==null || s.length()==0) return res;
        List<String> list = new ArrayList<String>();
        helper(res, list, s.trim());
        return res;
    }
    
    private static void helper(List<List<String>> res, List<String> list, String s){
        if(s.equals("")){
            res.add(new ArrayList<String>(list));
            return;
        }
        
        for(int i = 1; i <= s.length(); i++){
            if(!valid(s.substring(0,i))) continue;
            list.add(s.substring(0,i));
            helper(res, list, s.substring(i, s.length()));
            list.remove(list.size()-1);
        }
    }
    
    private static boolean valid(String s){
    	if(s.equals("")) return true;
        StringBuilder sb = new StringBuilder(s);
        return sb.toString().equals(sb.reverse().toString());
    }
    
    public static void main(String[] args){
    	System.out.println(partition("aab"));
    }
    
}
