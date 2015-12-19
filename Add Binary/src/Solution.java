public class Solution {
    public static String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int m = a.length();
        int n = b.length();
        if(m<n){
        	for(int i = 0; i < n-m; i ++){
        		a = a.replaceFirst("", "0");
        	}
        }else{
        	for(int i = 0; i < m-n;i++){
        		b = b.replaceFirst("", "0");
        	}
        }
        int carry = 0;
        for(int i = a.length()-1; i >= 0;i--){
        	int num1 = a.charAt(i) - '0';
        	int num2 = b.charAt(i) - '0';
        	int sum = num1 + num2 + carry;
        	if(sum>=2){
            	sb.insert(0, sum-2);
            	carry = 1;
        	}else{
        		sb.insert(0, sum );
        		carry = 0;
        	}
        }
        if(carry==1)
        	sb.insert(0, 1);
        return sb.toString();

    }
    
    public static void main(String[] args){
    	String s = "aa";
    	System.out.println(addBinary("1010","1011"));
    }
}