package FB;

public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        if(s == null || s.length() == 0){
            return true;
        }
        int i = 0;
        int j = s.length() - 1;
        while(i < j){
            char c1 = s.charAt(i);
            while(!valid(c1) && i < s.length() - 1){
                i++;
                c1 = s.charAt(i);
            }
            char c2 = s.charAt(j);
            while(!valid(c2) && j > 0){
                j--;
                c2 = s.charAt(j);
            }
            if(i >= j){
                return true;
            }
            if(Character.toLowerCase(c1) != Character.toLowerCase(c2)){
                return false;
            }
            i++;
            j--;
            
        }
        return true;
    }
    
    private boolean valid(char c){
        if(c >= '0' && c <= '9'){
            return true;
        }
        if(c >= 'a' && c <= 'z'){
            return true;
        }
        if(c >= 'A' && c <= 'Z'){
            return true;
        }
        return false;
    }
}
