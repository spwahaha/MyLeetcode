
public class Solution {
    public int addDigits(int num) {
        while(num>9){
            num = decompose(num);
        }
        return num;
    }
    
    public int decompose(int n){
        return (n/10+n%10);
    }
    
    
    public static void main(String[] args){
    	Solution so = new Solution();
    	System.out.println(so.addDigits(12));

    }
}
