import java.util.HashMap;

public class AdditiveNumber {

    public static boolean isAdditiveNumber(String num) {
        if(num.length() < 3) return false;
        for(int i = 1; i < num.length(); i++){
            for(int j = i; j < num.length(); j++){
                String part1 = num.substring(0, i);
                String part2 = num.substring(i, j);
                if(part1.length() == 0 || part2.length() == 0) continue;
                if(part1.charAt(0) == '0' || part2.charAt(0) == '0'){
                    continue;
                }
                int val1 = 0;
                int val2 = 0;
                int res = 0;
                try{
                    val1 = Integer.parseInt(part1);
                    val2 = Integer.parseInt(part2);
                    res = val1 + val2;
                    if(res < 0) continue;
                }catch(Exception e){
                    continue;
                }
                if (num.substring(j).indexOf(""+res) == 0){
                    String part3 = "" + res;
                    int start = part1.length() + part2.length() + part3.length();
                    if(helper(val2, res,num.substring(start))){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    private static boolean helper(int val1, int val2, String s){
        if(s.length() == 0){
            return true;
        }
        int res = val1 + val2;
        if(res < 0){
            return false;
        }
        if(s.indexOf(""+res) != 0){
            return false;
        } 
        String part1 = "" + res;
        return helper(val2, res, s.substring(part1.length()));
    }

    
    public static void main(String[] args){
    	System.out.println(isAdditiveNumber("123"));
    }
}
