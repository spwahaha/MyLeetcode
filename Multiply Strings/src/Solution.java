public class Solution {
    public static String multiply(String num1, String num2) {
		
    	String sum = "0";
    	for(int i = num1.length()-1;i>=0;i--){
    		char c = num1.charAt(i);
    		String temp1 = mul(num2,c);
    		String temp2 = update(temp1,num1.length()-1-i);
    		sum = add(sum,temp2);
    	}
    	
    	for(int i = 0; i < sum.length()-1; i++){
    		if(sum.charAt(i)=='0'){
    			sum = sum.substring(i+1);
    		}
    		else break;
    	}
    	return sum;
        
    }



	private static String mul(String num2, char c) {
		// TODO Auto-generated method stub
		int carry = 0;
		String res = "";
		for(int i = num2.length()-1;i>=0;i--){
			int temp = Integer.parseInt(num2.substring(i, i+1)) * Integer.parseInt(""+c);
			temp +=carry;
			carry = temp/10;
			temp = temp%10;
			res = ""+temp+res;
		}
		if(carry!=0)
			res = ""+carry+res;
		return res;
	}

	private static String update(String temp1, int i) {
		// TODO Auto-generated method stub
		for(;i>0;i--){
			temp1 +="0";
		}
		
    	for(int j = 0; j < temp1.length()-1; j++){
    		if(temp1.charAt(j)=='0'){
    			temp1 = temp1.substring(j+1);
    		}
    		else break;
    	}
		return temp1;
	}
	
	private static String add(String sum, String temp1) {
		// TODO Auto-generated method stub
		int n = sum.length();
		int m = temp1.length();
		if(m>n){
			for(int i = 0; i < m-n;i++)
				sum = ""+0+sum;
		}else{
			for(int i = 0; i < n -m; i++)
				temp1 = ""+0+temp1;
		}
		String res = "";
		int carry = 0;
		for(int i = sum.length()-1;i>=0;i--){
			int num1 = Integer.parseInt(sum.substring(i,i+1));
			int num2 = Integer.parseInt(temp1.substring(i, i+1));
			int temp = num1 + num2 + carry;
			carry = temp/10;
			temp = temp%10;
			res = ""+temp+res;
		}
		if(carry!=0)
			res = ""+carry+res;
		
    	for(int j = 0; j < res.length()-1; j++){
    		if(res.charAt(j)=='0'){
    			res = res.substring(j+1);
    		}
    		else break;
    	}
		return res;
	}
	
	public static void main(String[] args){
		System.out.println(multiply("0","332620029"));
	}
}