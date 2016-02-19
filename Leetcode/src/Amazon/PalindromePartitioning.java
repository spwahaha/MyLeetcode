package Amazon;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<List<String>>();
        if(s == null || s.equals("")) return res;
        helper(res, new ArrayList<String>(), s);
        return res;
    }
    
    private void helper(List<List<String>> res, List<String> list, String s){
        if(s.equals("")){
            res.add(new ArrayList<String>(list));
        }else{
            for(int i = 1; i <= s.length(); i++){
                String sub = s.substring(0, i);
                if(isPalin(sub)){
                    list.add(sub);
                    helper(res, list, s.substring(i));
                    list.remove(list.size() - 1);
                }
            }
        }
    }
    
    private boolean isPalin(String s){
        int i = 0;
        int j = s.length() - 1;
        while(i < j){
            if(s.charAt(i++) != s.charAt(j--)){
                return false;
            }
        }
        return true;
    }
}
