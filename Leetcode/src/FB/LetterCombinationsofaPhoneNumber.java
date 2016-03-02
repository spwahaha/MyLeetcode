package FB;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsofaPhoneNumber {
    public List<String> letterCombinations(String digits) {
        String[] map = {"", "", "abc", "def","ghi","jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> res = new ArrayList<String>();
        if(digits == null || digits.length() < 1){
            return res;
        }
        helper(res, map, digits, "", 0);
        return res;
    }
    
    private void helper(List<String> res, String[] map, String digits, String combin,int start){
        if(start == digits.length()){
            res.add(combin);
            return;
        }else{
            char c = digits.charAt(start);
            if(c == '*' || c == '#'){
                return;
            }
            String chars = map[c-'0'];
            for(int i = 0; i < chars.length(); i++){
                char add = chars.charAt(i);
                helper(res, map, digits, combin+add, start + 1);
            }
        }
    }
}
