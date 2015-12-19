
public class Solution {
    public static int myAtoi(String str) {
        str = str.trim();
        if(str==null)
            return 0;
        int res = 0;
        boolean nega = false;
        for(int i = 0;i<str.length();i++){
            char temp = str.charAt(i);
            if(temp=='-'){
                if(i==0)
                    nega = true;
                else
                    return 0;    
            }
            else if(temp=='+'){
                if(i==0)
                    res = res;
                else return 0;
            }else{
                int num = 0;
                if(temp<'0'||temp>'9'){
                    break;
                }
                num = temp-'0';
                if (res > (Integer.MAX_VALUE - num) / 10) { //integer overflow.
                    res = (nega)? Integer.MIN_VALUE : Integer.MAX_VALUE;
                    return res;
                }

                res = res * 10 + num; 
            }
        }
        return nega?-res:res;
    }
    
    public static void main(String[] args){
    	System.out.println(myAtoi("2147483648"));
    }
}
